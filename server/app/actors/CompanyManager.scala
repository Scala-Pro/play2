package actors

import cats.effect._
import akka.actor.Actor
import akka.pattern.pipe
import akka.util.Timeout
import cats.effect.unsafe.implicits.global
import com.typesafe.scalalogging.LazyLogging
import db.module.Database
import play.api.Configuration
import protocols.{Company, CompanyWithoutId, CreateCompany, GetCompany}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

class CompanyManager @Inject() (implicit
  val configuration: Configuration
) extends Actor
    with LazyLogging {
  implicit val executionContext: ExecutionContext = context.dispatcher
  implicit val defaultTimeout: Timeout            = Timeout(10.seconds)

  val database: Database[IO] = Database[IO]
  override def receive: Receive = {
    case CreateCompany(company) =>
      createCompany(company).pipeTo(sender())

    case GetCompany() =>
      getCompany.pipeTo(sender())

    case other =>
      logger.error(s"CMD not found: [ $other]")
      sender() ! "Cmd not found!"
  }

  private def createCompany(value: CompanyWithoutId): Future[Company] =
    database.companyAlgebra.flatMap(_.create(value)).unsafeToFuture()

  private def getCompany: Future[List[Company]] = {
    database.companyAlgebra.flatMap(_.getCompanyNames()).unsafeToFuture()
  }
}
