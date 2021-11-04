package controllers

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import db.domain.Common.{CreateTeacher, CreateUser}
import db.domain.{Teacher, TeacherIdsiz, User, UserWithoutId}
import org.webjars.play.WebJarsUtil
import play.api.Configuration
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import protocols.StudentProtocol.{GetStudents, Student}
import protocols.UserProtocol.GetUsers
import views.html._
import views.html.user.user
import javax.inject._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.DurationInt

@Singleton
class HomeController @Inject() (
  val controllerComponents: ControllerComponents,
  val configuration: Configuration,
  implicit val webJarsUtil: WebJarsUtil,
  indexTemplate: index,
  surojiddinTemplate: surojiddin,
  testTemplate: test,
  userTemplate: user,
  gameTemplate: views.html.game.index,
  navbarTemp: views.html.navbar.index,
  chatDTemp: views.html.chatD.index,
  @Named("student-manager") val studentManager: ActorRef
)(implicit val ec: ExecutionContext)
    extends BaseController {

  implicit val defaultTimeout: Timeout = Timeout(60.seconds)

  val prizeList: List[Prize] = List(
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Strawberry.png"),
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Cherry.png"),
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Apple.png"))

  val user = UserWithoutId("name4")

  val teacher = TeacherIdsiz("teacher1")

  def index: Action[AnyContent] = Action(Ok(indexTemplate()))

  def surojiddin: Action[AnyContent] = Action(Ok(surojiddinTemplate()))

  def test: Action[AnyContent] = Action(Ok(testTemplate()))

  def userPage: Action[AnyContent] = Action(Ok(userTemplate()))

  def navbar: Action[AnyContent] = Action(Ok(navbarTemp()))

  def chatD: Action[AnyContent] = Action(Ok(chatDTemp()))

  def game: Action[AnyContent] = Action(Ok(gameTemplate()))

  implicit val userFormat: OFormat[User]   = Json.format[User]
  implicit val prizeFormat: OFormat[Prize] = Json.format[Prize]
  implicit val teacherFormat: OFormat[Teacher] = Json.format[Teacher]

  def getStudents: Action[AnyContent] = Action.async { implicit request =>
    {
      (studentManager ? GetStudents).mapTo[List[Student]].map { studetns =>
        Ok(Json.toJson(studetns))
      }
    }
  }

  def getPrizes: Action[AnyContent] = Action { implicit request =>
    {
      Ok(Json.toJson(prizeList))
    }
  }

  def createUser: Action[AnyContent] = Action.async { implicit request =>
    {
      (studentManager ? CreateUser(user))
        .mapTo[User].map { user =>
          Ok(Json.toJson(user))
        }
        .recover { case err =>
          println(s"Error: $err")
          BadRequest("Error")
        }

    }
  }
  def createTeacher: Action[AnyContent] = Action.async { implicit request =>
    {
      (studentManager ? CreateTeacher(teacher))
        .mapTo[Teacher].map { teacher =>
          Ok(Json.toJson(teacher))
        }
        .recover { case err =>
          println(s"Error: $err")
          BadRequest("Error")
        }

    }
  }

  def getUsers: Action[AnyContent] = Action.async { implicit request =>
  {
    (studentManager ? GetUsers).mapTo[List[User]].map { users =>
      Ok(Json.toJson(users))
    }
  }
  }

  case class Prize(prize: String)
}
