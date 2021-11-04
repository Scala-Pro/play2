package db.sql

import db.domain.{User, UserWithoutId}
import skunk._
import skunk.codec.all._
import skunk.implicits._

object UserSql {

  val codec: Codec[User] =
    (int4 ~ varchar ~ varchar ~ int4.opt).imap {
      case i ~ n ~ l ~ a => User(i, n, l, a)
    }(c => c.id ~ c.name ~ c.lastName ~ c.age)

  val insert: Query[UserWithoutId, User] =
    sql"""INSERT INTO "user" VALUES (DEFAULT, $varchar, $varchar, $int4) returning id, name, last_name, age"""
      .query(codec)
      .gcontramap[UserWithoutId]

  val selectAll: Query[Void, User] =
    sql"""SELECT * FROM "user" """.query(codec)
}


