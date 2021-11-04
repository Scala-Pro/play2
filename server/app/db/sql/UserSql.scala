package db.sql

import db.domain.{User, UserWithoutId}
import skunk._
import skunk.codec.all._
import skunk.implicits._

object UserSql {

  val codec: Codec[User] =
    (int4 ~ varchar).imap {
      case i ~ n => User(i, n)
    }(c => c.id ~ c.name)

  val insert: Query[UserWithoutId, User] =
    sql"""INSERT INTO "user" VALUES (DEFAULT, $varchar) returning id, name"""
      .query(codec)
      .gcontramap[UserWithoutId]

  val selectAll: Query[Void, User] =
    sql"""SELECT * FROM "user" """.query(codec)
}


