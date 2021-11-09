package db.algebra

import cats.effect._
import db.sql.CompanySql._
import protocols.{Company, CompanyWithoutId}
import skunk._

trait CompanyAlgebra[F[_]] {
  def create(company: CompanyWithoutId): F[Company]
}

object LiveCompanyAlgebra {
  def apply[F[_]: Async](session: Resource[F, Session[F]])(implicit F: Sync[F]): F[CompanyAlgebra[F]] =
    F.delay(
      new LiveCompanyAlgebra[F](session)
    )
}

final class LiveCompanyAlgebra[F[_]: Async] private (
  session: Resource[F, Session[F]]
) extends CompanyAlgebra[F] {

  override def create(company: CompanyWithoutId): F[Company] =
    session.use(_.prepare(insert).use(_.unique(company)))
}
