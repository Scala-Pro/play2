package db.domain

import db.domain.Teacher._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class TeacherIdsiz(
  name: TeacherName
)

object TeacherIdsiz {
  implicit val usernameDecoder: Decoder[TeacherIdsiz] = deriveDecoder[TeacherIdsiz]
  implicit val usernameEncoder: Encoder[TeacherIdsiz] = deriveEncoder[TeacherIdsiz]
}



