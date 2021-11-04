package actors

import akka.actor.{Actor, ActorSystem}
import akka.pattern.pipe
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.scalalogging.LazyLogging
import play.api.{Configuration, Environment}
import protocols.StudentProtocol.{GetStudents, GetUser, Student, User}

import javax.inject.Inject
import scala.concurrent.duration.DurationInt
import scala.concurrent.{ExecutionContext, Future}

class UserManager @Inject()(
                             val environment: Environment,
                             implicit val configuration: Configuration,
                           )(implicit val actorSystem: ActorSystem)
  extends Actor with LazyLogging {

  implicit val executionContext: ExecutionContext = context.dispatcher
  implicit val defaultTimeout: Timeout = Timeout(10.seconds)
  implicit val tempList: List[User] = List.empty[User]


  override def preStart(): Unit = {
    tempList
  }

  override def receive: Receive = {
    case GetUser =>
      getUser.pipeTo(sender()).mapTo[List[User]].map{user =>
      logger.debug(s"$user")
    }
  }

  val userList: List[User] = List(
    User("Behruz", "Burxonov", 24),
    User("Sardor", "Jamshidov", 22),
    User("Mack", "Daniel", 19),
    User("Dimitry", "Kuskin", 35),
    User("Ronaldo", "Cristiano", 20),
    User("Elon", "Mask", 23),
    User("Martin", "Odersky", 28)
  )

  private def getUser: Future[List[User]] = {
    logger.debug(s"Users........")
    Future.successful(userList)
    // write code to ask students from DB
  }




}
