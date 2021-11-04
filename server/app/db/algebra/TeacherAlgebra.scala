package db.algebra

import cats.effect._
import db.sql.TeacherSql._
import db.domain.{Teacher, TeacherIdsiz}
import skunk._

trait TeacherAlgebra[F[_]]{
  def create(teacher: TeacherIdsiz): F[Teacher]

  def findAll: F[List[Teacher]]
}

object TeacherAlgebra {

  def apply[F[_]: Async](session: Resource[F, Session[F]]): TeacherAlgebra[F] =
    new TeacherAlgebra[F] {
      override def create(teacher: TeacherIdsiz): F[Teacher] =
        session.use(_.prepare(insert).use(_.unique(teacher)))

      override def findAll: F[List[Teacher]] =
        session.use(_.execute(selectAll))
    }

}
