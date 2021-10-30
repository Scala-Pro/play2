import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder, Printer}
import io.circe.parser.parse
import io.circe.syntax.EncoderOps

object Protocol {

  case class User(firstname: String, lastname: String, email: String, phone: String, age: Int)
  case class Prize(image: String)

  object User {
    implicit val decoderUser: Decoder[User] = deriveDecoder[User]
    implicit val encoderUser: Encoder[User] = deriveEncoder[User]
  }

  object Prize {
    implicit val decoderUser: Decoder[Prize] = deriveDecoder[Prize]
    implicit val encoderUser: Encoder[Prize] = deriveEncoder[Prize]
  }

	sealed trait Page
	case object Home extends Page
	case object CreateUser extends Page
	case object UserDashboard extends Page

  case class Members(firstname: String, lastname: String, phone: String, direction: String)

  object Members {
    implicit val decoderMembers: Decoder[Members] = deriveDecoder[Members]
    implicit val encoderMembers: Encoder[Members] = deriveEncoder[Members]
  }

  val printer: Printer = Printer.noSpaces.copy(dropNullValues = true)

  def toJsonString[T: Encoder](t: T): String = t.asJson.printWith(printer)

  def fromJson[T: Decoder](s: String): T =
    parse(s).fold(throw _, json => json).as[T].fold(throw _, identity)

}
