package module

import cats.effect.kernel.Async
import cats.effect.std.Console
import cats.effect.{Async, Concurrent, Resource}
import cats.implicits.catsSyntaxOptionId
import fs2.io.net.Network
import natchez.Trace
import skunk.Session

trait Database[F[_]] {
  val user: Resource[F, UserAlgebra[F]]
}


object Database {
  def apply[F[_]:Concurrent: Trace: Network: Console]: Database[F] = new Database[F] {
    private val session: Resource[F, Session[F]] =
      Session.single(
        host = "localhost",
        port = 5432,
        database = "playexample",
        user = "admin",
        password = "admin123".some)

    override val user: Resource[F, Any] = _
  }

}
