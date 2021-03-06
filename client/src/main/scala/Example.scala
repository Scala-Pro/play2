import Protocol._
import japgolly.scalajs.react.component.Scala.{BackendScope, Component}
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, CtorType, ScalaComponent}
import org.scalajs.dom.document
import org.scalajs.dom.html.{Button, Div, TableRow}
import org.scalajs.dom.raw.HTMLInputElement

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Example")
class Example extends AjaxImplicits {

  type AppComponentType = Component[Unit, State, Backend, CtorType.Nullary]
  case class State(
                    login: String = "",
                    password: String = "",
                    succeed: Boolean = false,
                    users: List[User] = Nil
                  )

  class Backend($: BackendScope[Unit, State]) {

    def onChangeLogin(e: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(login = e.target.value))

    def onChangePassword(e: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(password = e.target.value))

    def onSubmit(implicit state: State): Callback =
      if (state.login.isEmpty)
        Callback.alert("Please enter login")
      else if (state.password.isEmpty)
        Callback.alert("Please enter password")
      else
        $.modState(_.copy(succeed = true))
    Callback.alert("Successful")

    def loginForm(implicit state: State): VdomTagOf[Div] =
      <.div(^.cls := "row")(
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Login:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeLogin)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Password:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangePassword)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.button(^.cls := "btn btn-success")("Submit", ^.onClick --> onSubmit).when(state.login == "Doniyor")
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Additional question:"),
            <.input(^.cls := "form-control")
          )
        ).when(state.succeed),
        <.div(^.cls := "col-6 offset-3")(
          "Length of data: " + state.login.length
        )
      )

    def getAllUsers: Callback =
      get(Urls.GetUser)
        .fail(onError)
        .done[List[User]] { users =>
          $.modState(_.copy(users = users))
        }.asCallback

    def userButton(implicit state: State): VdomTagOf[Button] =
      <.button(^.cls := "btn btn-primary btn-md", ^.onClick --> getAllUsers)("Get Users")

    def createRow(user: User): VdomTagOf[TableRow] =
      <.tr(
        <.td(user.fullName),
        <.td(user.email),
        <.td(user.phone),
        <.td(user.age)
      )

    def userTable(implicit state: State): TagMod =
      <.table(^.cls := "table table-bordered table-striped mt-5")(
        <.thead(<.tr(<.th("First Name"), <.th("Last Name"), <.th("Email"), <.th("Phone"), <.th("Age"))),
        <.tbody(state.users map createRow: _*)).when(state.users.nonEmpty)

    def render(implicit state: State): VdomTagOf[Div] =
      <.div(userButton, userTable)
  }

  val AppComponent: AppComponentType =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  AppComponent().renderIntoDOM(document.getElementById("app"))
}
