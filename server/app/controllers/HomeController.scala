package controllers

import org.webjars.play.WebJarsUtil
import play.api.Configuration
import play.api.http.Writeable
import play.api.libs.json
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Result}
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
                               userTemplate: user
                              )
                              (implicit val ec: ExecutionContext)
  extends BaseController {

  def index: Action[AnyContent] = Action(Ok(indexTemplate()))
  def surojiddin: Action[AnyContent] = Action(Ok(surojiddinTemplate()))
  def test: Action[AnyContent] = Action(Ok(testTemplate()))
  def userPage: Action[AnyContent] = Action(Ok(userTemplate()))

  case class User(firstname: String, lastname: String, email: String, phone: String, age: Int)
  implicit val userFormat = Json.format[User]

//  object User {
//    implicit val decoderUser: Decoder[User] = deriveDecoder[User]
//    implicit val encoderUser: Encoder[User] = deriveEncoder[User]
//  }


  val userList = List(
    User("Akmal", "Burxonov", "akmal12@gmail.com", "+998998877412", 24),
    User("Sardor", "Jamshidov", "sardor@inbox.ru", "+998905674545", 22),
    User("Mack", "Daniel", "mack@gmail.com", "+998932344355", 19),
    User("Dimitry", "Kuskin", "kuskin@gmail.com", "+998997564587", 35),
    User("Ronaldo", "Cristiano", "cr7@gmail.com", "+998998854647", 20),
    User("Elon", "Mask", "elon@gmail.com", "+998913455445", 23),
    User("Martin", "Odersky", "martin@gmail.com", "+998986785677", 28)
  )


  def getUsers: Result =
    Ok(json.Json.toJson(userList))


}