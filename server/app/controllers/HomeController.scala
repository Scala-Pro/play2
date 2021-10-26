package controllers

import org.webjars.play.WebJarsUtil
import play.api.Configuration
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import views.html._

import javax.inject._
import scala.concurrent.ExecutionContext

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents,
                               val configuration: Configuration,
                               implicit val webJarsUtil: WebJarsUtil,
                               indexTemplate: index,
                               testTemplate: test,
                               denisTemplate: denis)
                              (implicit val ec: ExecutionContext)
  extends BaseController {

  def index: Action[AnyContent] = Action(Ok(indexTemplate()))
  def test: Action[AnyContent] = Action(Ok(testTemplate()))
  def denis: Action[AnyContent] = Action(Ok(denisTemplate("user")))

}