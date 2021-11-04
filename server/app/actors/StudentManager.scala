package actors

import akka.actor.{Actor, ActorSystem}
import akka.pattern.pipe
import akka.util.Timeout
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import com.typesafe.scalalogging.LazyLogging
import db.domain.Common.CreateUser
import db.domain.{User, UserWithoutId}
import db.module.Database
import play.api.{Configuration, Environment}
import protocols.StudentProtocol.{GetStudents, Student}
import protocols.UserProtocol.GetUsers

import javax.inject.Inject
import scala.concurrent.duration.DurationInt
import scala.concurrent.{ExecutionContext, Future}

class StudentManager @Inject()(
                             val environment: Environment,
                             implicit val configuration: Configuration,
                           )(implicit val actorSystem: ActorSystem)
  extends Actor with LazyLogging {

  implicit val executionContext: ExecutionContext = context.dispatcher
  implicit val defaultTimeout: Timeout = Timeout(60.seconds)
  val database: Database[IO] = Database[IO]

  override def receive: Receive = {
    case GetStudents =>
      getStudents.pipeTo(sender())

    case CreateUser(user) =>
      createUser(user).pipeTo(sender())

    case GetUsers =>
      getUsers.pipeTo(sender())
  }

  val userList: List[Student] = List(
    Student("Behruz", "Burxonov", "akmal12@gmail.com", "+998998877412", 24),
    Student("Sardor", "Jamshidov", "sardor@inbox.ru", "+998905674545", 22),
    Student("Mack", "Daniel", "mack@gmail.com", "+998932344355", 19),
    Student("Dimitry", "Kuskin", "kuskin@gmail.com", "+998997564587", 35),
    Student("Ronaldo", "Cristiano", "cr7@gmail.com", "+998998854647", 20),
    Student("Elon", "Mask", "elon@gmail.com", "+998913455445", 23),
    Student("Martin", "Odersky", "martin@gmail.com", "+998986785677", 28)
  )

  private def getStudents: Future[List[Student]] = {
    logger.debug(s"Students........")
    Future.successful(userList)
    // write code to ask students from DB
  }

  def createUser(user: UserWithoutId): Future[User] = {
    database.userAlgebra.flatMap(_.create(user)).unsafeToFuture()
  }

  def getUsers: Future[List[User]] = {
    database.userAlgebra.flatMap(_.findAll).unsafeToFuture()
  }




}
