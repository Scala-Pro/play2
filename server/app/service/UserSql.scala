package service

import skunk._
import skunk.codec.AllCodecs
import skunk.codec.all._
import skunk.implicits._

object UserSql extends AllCodecs {

  val codec: Codec[User] =
    (int4 ~ varchar).imap {
      case i ~ n => User(i, n)
    }(c => c.id ~ c.name)

  val insert: Query[UserWithoutId, User] =
    sql"""INSERT INTO "user" VALUES (DEFAULT, $varchar) returning id, name"""
      .query(codec)
      .gcontramap[User]

//  val selectAll: Query[Void, User] =
//    sql"""SELECT * FROM "user" """.query(codec)
}


