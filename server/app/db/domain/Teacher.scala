package db.domain

import db.domain.Teacher._
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class Teacher(
  id: TeacherId,
  name: TeacherName
)

object Teacher {
  type TeacherId = Int
  type TeacherName = String

  implicit val teacherDecoder: Decoder[Teacher] = deriveDecoder[Teacher]
  implicit val teacherEncoder: Encoder[Teacher] = deriveEncoder[Teacher]
}