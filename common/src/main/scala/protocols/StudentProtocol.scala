package protocols

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import play.api.libs.json.{Json, OFormat}

object StudentProtocol {

  case class Student(firstname: String, lastname: String, email: String, phone: String, age: Int)

  implicit val studentFormatter: OFormat[Student] = Json.format[Student]

  object Student {
    implicit val rateStatsDec: Decoder[Student] = deriveDecoder[Student]
    implicit val rateStatsEnc: Encoder[Student] = deriveEncoder[Student]
  }

  case object GetStudents

}
