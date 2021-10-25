import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder, Printer}
import io.circe.parser.parse
import io.circe.syntax.EncoderOps

object Protocol {

	case class User(firstname: String, lastname: String, email: String, phone: String, age: Int)

	object User {
		implicit val decoderUser: Decoder[User] = deriveDecoder[User]
		implicit val encoderUser: Encoder[User] = deriveEncoder[User]
	}

	val printer: Printer = Printer.noSpaces.copy(dropNullValues = true)

	def toJsonString[T: Encoder](t: T): String = t.asJson.printWith(printer)

	def fromJson[T: Decoder](s: String): T =
		parse(s).fold(throw _, json => json).as[T].fold(throw _, identity)

}
