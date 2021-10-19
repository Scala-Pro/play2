import japgolly.scalajs.react.{Callback, ScalaComponent}
import japgolly.scalajs.react.callback.CallbackTo
import japgolly.scalajs.react.component.Scala.BackendScope
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.{console, document}
import org.scalajs.dom.html.Div
import org.scalajs.dom.raw.HTMLInputElement

object Main extends App {
 case class State(login: String = "")

  class Backend($: BackendScope[Unit, State]) {

    def onChangeLogin(e: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(login = e.target.value))

    def loginForm(implicit state: State): VdomTagOf[Div] =
      <.div(^.cls := "row")(
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group") (
            <.label(^.cls := "form-label")("Login:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeLogin)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          "Length of data: " + state.login.length
        )
      )

    def render(implicit state: State): VdomTagOf[Div] =
      <.div(^.cls := "container")(loginForm)
  }

  val AppComponent =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  AppComponent().renderIntoDOM(document.getElementById("app"))
}
