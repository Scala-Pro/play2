package db.sql

import db.domain.{Teacher, TeacherIdsiz}
import skunk._
import skunk.codec.all._
import skunk.implicits._

object TeacherSql {

  val codec: Codec[Teacher] =
    (int4 ~ varchar).imap {
      case i ~ n => Teacher(i, n)
    }(c => c.id ~ c.name)

  val insert: Query[TeacherIdsiz, Teacher] =
    sql"""INSERT INTO "teacher" VALUES (DEFAULT, $varchar) returning id, name"""
      .query(codec)
      .gcontramap[TeacherIdsiz]

  val selectAll: Query[Void, Teacher] =
    sql"""SELECT * FROM "teacher" """.query(codec)
}


