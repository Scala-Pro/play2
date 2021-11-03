import cats.implicits._
import cats.effect.kernel.Async
import service.{User, UserWithoutId}
import skunk.{Command, Session}
import service.UserSql.insert

trait UserAlgebra[F[_]]{
  def create(user: UserWithoutId): F[User]
}

object UserAlgebra {

  def apply[F[_]: Async](session: Session[F]): UserAlgebra[F] =
    new UserAlgebra[F] {
      override def create(user: UserWithoutId): F[User] = {
        session.prepare(insert).use(_.unique(user))
      }
    }

}
