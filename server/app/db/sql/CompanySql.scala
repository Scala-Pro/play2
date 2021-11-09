package db.sql

import protocols.{Company, CompanyWithoutId}
import skunk.codec.all.{int4, varchar}
import skunk._
import skunk.implicits._

object CompanySql {

  val codec: Codec[Company] =
    (int4 ~ varchar ~ varchar ~ varchar ~ int4).imap {
      case i ~ n ~ e ~ ph ~ wc => Company(i, n, e, ph, wc)
    }(c => c.id ~ c.name ~ c.email ~ c.phone ~ c.workerCount)

  val insert: Query[CompanyWithoutId, Company] =
    sql"""INSERT INTO "company" VALUES (DEFAULT, $varchar, $varchar, $varchar, $int4) returning *"""
      .query(codec)
      .gcontramap[CompanyWithoutId]

  val getCompany: Query[Void, Company] =
    sql""" SELECT * FROM "company" """.query(codec)
}
