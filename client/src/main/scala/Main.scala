import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.component.Scala.BackendScope
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document
import org.scalajs.dom.html.Div

object Main extends App {
 case class State()

  class Backend($: BackendScope[Unit, State]) {
    def render(implicit state: State): VdomTagOf[Div] =
      <.div("Hello reactJs")
  }

  val AppComponent =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  AppComponent().renderIntoDOM(document.getElementById("app"))
}
