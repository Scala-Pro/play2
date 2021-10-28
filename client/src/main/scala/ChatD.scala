import Protocol._
import japgolly.scalajs.react.component.Scala.{BackendScope, Component}
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, CtorType, ScalaComponent}
import org.scalajs.dom.document
import org.scalajs.dom.html.{Div, Element, TableRow}
import org.scalajs.dom.raw.HTMLInputElement

import scala.scalajs.js.annotation.JSExportTopLevel

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Chat")
class ChatD {
  type AppComponentType = Component[Unit, State, Backend, CtorType.Nullary]

  case class State()

  class Backend($: BackendScope[Unit, State]) {
    def chatInterface: VdomTagOf[Div] =
    <.div(^.className := "chat",
      <.div(^.className := "chat-title",
        <.h1("가을❤"),
        <.h2("qiutian"),
        <.figure(^.className := "avatar",
          <.img(^.src := "https://www.pikpng.com/pngl/b/109-1099794_ios-emoji-emoji-iphone-ios-heart-hearts-spin.png")
        )
      ),
      <.div(^.className := "messages",
        <.div(^.className := "messages-content")
      ),
      <.div(^.className := "message-box",
        <.textarea(^.`type` := "text", ^.className := "message-input", ^.placeholder := "Type message..."),
        <.button(^.`type` := "submit", ^.className := "message-submit","Send")
      )
    )
    <.div(^.className := "bg")

    def render(implicit state: State): VdomTagOf[Div] =
      <.div(chatInterface)
  }

  val NavbarComponent: AppComponentType =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  NavbarComponent().renderIntoDOM(document.getElementById("chatD"))
}
