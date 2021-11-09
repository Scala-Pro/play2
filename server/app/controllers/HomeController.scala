package controllers

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import cats.implicits.catsSyntaxApplicativeError
import com.typesafe.scalalogging.LazyLogging
import db.domain.Common.CreateUser
import db.domain.{User, UserWithoutId}
import org.webjars.play.WebJarsUtil
import play.api.Configuration
import play.api.libs.functional.syntax._
import play.api.libs.json.{Json, OFormat, Reads, __}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import protocols.StudentProtocol.{GetStudents, Student}
import protocols.UserProtocol.GetUsers
import protocols.{Company, CompanyWithoutId, CreateCompany, GetCompany}
import views.html._
import views.html.user.user

import javax.inject._
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.DurationInt

object HomeController {
  implicit val companyReads: Reads[CompanyWithoutId] = (
    (__ \ "name").read[String] and
      (__ \ "email").read[String] and
      (__ \ "phone").read[String] and
      (__ \ "workerCount").read[Int]
  )(CompanyWithoutId.apply _)

  implicit val companyFormat: OFormat[Company] = Json.format[Company]
}

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
  @Named("student-manager") val studentManager: ActorRef,
  @Named("company-manager") val companyManager: ActorRef
)(implicit val ec: ExecutionContext)
    extends BaseController
    with LazyLogging {

  import HomeController._
  implicit val defaultTimeout: Timeout = Timeout(10.seconds)

  val prizeList: List[Prize] = List(
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Strawberry.png"),
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Cherry.png"),
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Apple.png")
  )

  val user: UserWithoutId = UserWithoutId("Martin", "Odersky")

  def index: Action[AnyContent] = Action(Ok(indexTemplate()))

  def surojiddin: Action[AnyContent] = Action(Ok(surojiddinTemplate()))

  def test: Action[AnyContent] = Action(Ok(testTemplate()))

  def userPage: Action[AnyContent] = Action(Ok(userTemplate()))

  def navbar: Action[AnyContent] = Action(Ok(navbarTemp()))

  def chatD: Action[AnyContent] = Action(Ok(chatDTemp()))

  def game: Action[AnyContent] = Action(Ok(gameTemplate()))

  implicit val userFormat: OFormat[User]   = Json.format[User]
  implicit val prizeFormat: OFormat[Prize] = Json.format[Prize]

  def getStudents: Action[AnyContent] = Action.async {
    (studentManager ? GetStudents)
      .mapTo[List[Student]]
      .map { students =>
        Ok(Json.toJson(students))
      }
      .recover { case e =>
        logger.error("Error happened", e)
        Ok("Error")
      }
  }

  def getPrizes: Action[AnyContent] = Action {
    Ok(Json.toJson(prizeList))
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

  }}

  def getUsers: Action[AnyContent] = Action.async {
    (studentManager ? GetUsers).mapTo[List[User]].map { users =>
      Ok(Json.toJson(users))
    }
  }

  case class Prize(prize: String)

  def createCompany: Action[CompanyWithoutId] = Action.async(parse.json[CompanyWithoutId]) { request =>
    (companyManager ? CreateCompany(request.body))
      .mapTo[Company]
      .map { company =>
        Ok(Json.toJson(company))
      }
      .handleError { error =>
        logger.error("Error occurred while create Company. Error: ", error)
        BadRequest("Tashkilot yaratishda xatolik yuz berdi. Iltimos qayta harakat qilib ko'ring!")
      }
  }

  def getCompany: Action[AnyContent] = Action.async { request =>
    (companyManager ? GetCompany())
      .mapTo[List[Company]]
      .map { company =>
        Ok(Json.toJson(company))
      }
      .handleError { error =>
        logger.error("Error occurred while create Company. Error: ", error)
        BadRequest("Tashkilot yaratishda xatolik yuz berdi. Iltimos qayta harakat qilib ko'ring!")
      }
  }
}
