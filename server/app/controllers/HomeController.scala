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
                               surojiddinTemplate: surojiddin,
                               testTemplate: test)
                              (implicit val ec: ExecutionContext)
  extends BaseController {

  def index: Action[AnyContent] = Action(Ok(indexTemplate()))
  def surojiddin: Action[AnyContent] = Action(Ok(surojiddinTemplate()))
  def test: Action[AnyContent] = Action(Ok(testTemplate()))

}