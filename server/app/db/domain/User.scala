package db.domain

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import User.{Age, LastName, UserId, UserName}
case class User (
  id: UserId,
  name: UserName,
  lastName: LastName,
  age: Option[Age] = None
)

object User {
  type UserId = Int
  type UserName = String
  type LastName = String
  type Age = Int

  implicit val userDecoder: Decoder[User] = deriveDecoder[User]
  implicit val userEncoder: Encoder[User] = deriveEncoder[User]
}