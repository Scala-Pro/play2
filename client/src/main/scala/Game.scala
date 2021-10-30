import Protocol._
import japgolly.scalajs.react.component.Scala.{BackendScope, Component}
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, CtorType, ScalaComponent}
import org.scalajs.dom.document
import org.scalajs.dom.html.{Button, Div, TableRow}
import org.scalajs.dom.raw.HTMLInputElement

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Game")
class Game extends AjaxImplicits {

  type AppComponentType = Component[Unit, State, Backend, CtorType.Nullary]
  case class State(prizes: List[Prize] = Nil)

  class Backend($: BackendScope[Unit, State]) {

    def getAllPrize: Callback =
      get(Urls.GetUser)
        .fail(onError)
        .done[List[Prize]] { prizes =>
          $.modState(_.copy(prizes = prizes))
        }.asCallback

    def playButton(implicit state: State): VdomTagOf[Button] =
      <.button(^.cls := "btn btn-primary btn-md", ^.onClick --> getAllPrize)("Get Free Prize")

    def gameRoulette(implicit state: State): TagMod =
      ???

    def render(implicit state: State): VdomTagOf[Div] =
      <.div(playButton)
  }

  val AppComponent: AppComponentType =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  AppComponent().renderIntoDOM(document.getElementById("app-game"))
}
