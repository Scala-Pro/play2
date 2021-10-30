import Protocol._
import japgolly.scalajs.react.component.Scala.{BackendScope, Component}
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, CtorType, ScalaComponent}
import org.scalajs.dom.document
import org.scalajs.dom.html.{Div, Element, TableRow}
import org.scalajs.dom.raw.HTMLInputElement

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Navbar")
class Navbar {

  type AppComponentType = Component[Unit, State, Backend, CtorType.Nullary]

  case class State(
    firstname: String = "",
    lastname: String = "",
    age: Int = 0,
    users: List[User] =Nil,
    page: Page = Home,
    messages: List[Message] = Nil,
    text: String = ""
  )

  sealed trait Owner
  case object Me extends Owner
  case object You extends Owner

  case class Message(text: String, owner: Owner)

  class Backend($: BackendScope[Unit, State]) {
    def onSend(implicit state: State): Callback =
      $.modState(_.copy(messages = state.messages :+ Message(state.text, Me) :+ Message(fakeMessage, You)))

    def changePage(selectedPage: Page): Callback =
      $.modState(_.copy(page = selectedPage))

    def navbar(implicit state: State): VdomTagOf[Element] =
      <.nav(^.className := "navbar navbar-expand-lg navbar-light bg-light",
        <.div(^.className := "container-fluid",
          <.a(^.className := "navbar-brand", ^.href := "#", "Navbar"),
          <.button(^.className := "navbar-toggler", ^.`type` := "button", VdomAttr("data-bs-toggle") := "collapse", VdomAttr("data-bs-target") := "#navbarNav", VdomAttr("aria-controls") := "navbarNav", VdomAttr("aria-expanded") := "false", VdomAttr("aria-label") := "Toggle navigation",
            <.span(^.className := "navbar-toggler-icon")
          ),
          <.div(^.className := "collapse navbar-collapse", ^.id := "navbarNav",
            <.ul(^.className := "navbar-nav",
              <.li(^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls := "active").when(state.page == Home),
                  ^.onClick --> changePage(Home))("Home")
              ),
              <.li(^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls := "active").when(state.page == CreateUser),
                  ^.onClick --> changePage(CreateUser))("User")
              ),
              <.li(^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls := "active").when(state.page == UserDashboard),
                  ^.onClick --> changePage(UserDashboard))("Users")
              ),
              <.li(^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls := "active").when(state.page == ChatUI),
                  ^.onClick --> changePage(ChatUI))("Chat")
              )
            )
          )
        )
      )

    def onChangeAge(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(age = event.target.value.toInt))

    def onChangeFirstname(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(firstname = event.target.value))

    def onChangeLastname(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(lastname = event.target.value))

    def onChangeMessage(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(text = event.target.value))

    def onSubmit(implicit state: State): Callback =
      $.modState(_.copy(users = state.users :+ User(state.firstname, state.lastname, "", "", state.age)))

    def homePage(implicit state: State): TagMod =
      <.div("Home page.").when(state.page == Home)

    def userForm(implicit state: State): TagMod =
      <.div(^.cls := "row")(
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Firstname:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeFirstname)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Lastname:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeLastname)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Age:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeAge)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.button(^.cls := "btn btn-success")("Submit", ^.onClick --> onSubmit)
        )
      ).when(state.page == CreateUser)

    def chatForm(implicit state: State): TagMod =
      <.div(^.cls := "bggg")(
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
            <.textarea(^.`type` := "text", ^.className := "message-input", ^.onChange ==> onChangeMessage, ^.placeholder := "Type message..."),
            <.button(^.`type` := "submit", ^.className := "message-submit",^.onClick --> onSend,"Send")
          )
        ),
        <.div(^.className := "bg")
      ).when(state.page == ChatUI)

    val Fake: Array[String] = Array(
      "사랑해❤",
      "지은 뿐이야",
      "나 이거 만드느라 고생했어.",
      "여보 뭐해?",
      "휴 힘들다...",
      "That's awesome",
      "Codepen is a nice place to stay",
      "I think you're a nice person",
      "Why do you think that?",
      "Can you explain?",
      "Anyway I've gotta go now",
      "It was a pleasure chat with you",
      "Time to make a new codepen",
      "Bye",
      ":)"
    )

    def fakeMessage: String = {
      Fake(scala.util.Random.nextInt(Fake.length))
    }

    def createRow(user: User): VdomTagOf[TableRow] =
      <.tr(
        <.td(user.firstname),
        <.td(user.lastname),
        <.td(user.email),
        <.td(user.phone),
        <.td(user.age)
      )

    def createMessageRow(message: Message): VdomTagOf[TableRow] =
      if (message.owner == Me) {
        <.tr(
          <.td(message.text),
          <.td("Writing.....")
        )
      } else {
        <.tr(
          <.td("Writing....."),
          <.td(message.text)
        )
      }


    def userTable(implicit state: State): TagMod =
      <.table(^.cls := "table table-bordered table-striped mt-5")(
        <.thead(<.tr(<.th("First Name"), <.th("Last Name"), <.th("Email"), <.th("Phone"), <.th("Age"))),
        <.tbody(state.users map createRow: _*)).when(state.page == UserDashboard)

    def messageTable(implicit state: State): TagMod =
      <.table(^.cls := "table table-bordered table-striped mt-5")(
        <.thead(<.tr(<.th("Me"),<.th("You"))),
        <.tbody(state.messages map createMessageRow: _*)).when(state.page == ChatUI)


    def render(implicit state: State): VdomTagOf[Div] =
      <.div(^.cls := "container")(navbar, homePage, userForm, userTable, chatForm, messageTable)
  }

  val NavbarComponent: AppComponentType =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  NavbarComponent().renderIntoDOM(document.getElementById("navbar-app"))
}
