package controllers

import org.webjars.play.WebJarsUtil
import play.api.Configuration
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import views.html._
import views.html.user.user

import javax.inject._
import scala.concurrent.ExecutionContext

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents,
                               val configuration: Configuration,
                               implicit val webJarsUtil: WebJarsUtil,
                               indexTemplate: index,
                               surojiddinTemplate: surojiddin,
                               testTemplate: test,
                               userTemplate: user,
                               gameTemplate: views.html.game.index,
                               navbarTemp: views.html.navbar.index,
                               chatDTemp: views.html.chatD.index
                              )
                              (implicit val ec: ExecutionContext)
    extends BaseController {

  case class User(firstname: String, lastname: String, email: String, phone: String, age: Int)
  case class Prize(prize: String)

  val userList: List[User] = List(
    User("Akmal", "Burxonov", "akmal12@gmail.com", "+998998877412", 24),
    User("Sardor", "Jamshidov", "sardor@inbox.ru", "+998905674545", 22),
    User("Mack", "Daniel", "mack@gmail.com", "+998932344355", 19),
    User("Dimitry", "Kuskin", "kuskin@gmail.com", "+998997564587", 35),
    User("Ronaldo", "Cristiano", "cr7@gmail.com", "+998998854647", 20),
    User("Elon", "Mask", "elon@gmail.com", "+998913455445", 23),
    User("Martin", "Odersky", "martin@gmail.com", "+998986785677", 28)
  )

  val prizeList: List[Prize] = List(
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Strawberry.png"),
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Cherry.png"),
    Prize("https://cdn0.iconfinder.com/data/icons/fruits/128/Apple.png")
  )

  def index: Action[AnyContent] = Action(Ok(indexTemplate()))

  def surojiddin: Action[AnyContent] = Action(Ok(surojiddinTemplate()))

  def test: Action[AnyContent] = Action(Ok(testTemplate()))

  def userPage: Action[AnyContent] = Action(Ok(userTemplate()))
  def navbar: Action[AnyContent] = Action(Ok(navbarTemp()))
  def chatD: Action[AnyContent] = Action(Ok(chatDTemp()))
  def game: Action[AnyContent] = Action(Ok(gameTemplate()))

  implicit val userFormat: OFormat[User] = Json.format[User]
  implicit val prizeFormat: OFormat[Prize] = Json.format[Prize]

  def getUsers: Action[AnyContent] = Action { implicit request => {
    Ok(Json.toJson(userList))
  }
  }

  def getPrizes: Action[AnyContent] = Action { implicit request => {
    Ok(Json.toJson(prizeList))
  }
  }
}