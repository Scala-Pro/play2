import japgolly.scalajs.react.{Callback, ScalaComponent}
import japgolly.scalajs.react.callback.CallbackTo
import japgolly.scalajs.react.component.Scala.BackendScope
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.{console, document}
import org.scalajs.dom.html.{Button, Div, TableRow}
import org.scalajs.dom.raw.HTMLInputElement
import Protocol._

object Main extends App with AjaxImplicits {
 case class State(login: String = "", password: String = "", succeed: Boolean = false, users: List[User] = Nil, courses: List[Course] = Nil)

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
          <.div(^.cls := "form-group") (
            <.label(^.cls := "form-label")("Login:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeLogin)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group") (
            <.label(^.cls := "form-label")("Password:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangePassword)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.button(^.cls := "btn btn-success")("Submit", ^.onClick --> onSubmit).when(state.login == "Doniyor")
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group") (
            <.label(^.cls := "form-label")("Additional question:"),
            <.input(^.cls := "form-control")
          )
        ).when(state.succeed),
        <.div(^.cls := "col-6 offset-3")(
          "Length of data: " + state.login.length
        )
      )

    def getAllUsers: Callback =
      $.modState(_.copy(courses = Nil)) >>
      get(Urls.GetUser)
        .fail(onError)
        .done[List[User]] { users =>
          $.modState(_.copy(users = users))
        }.asCallback

    def getAllCourses: Callback =
      $.modState(_.copy(users = Nil)) >>
      get(Urls.GetCourses)
        .fail(onError)
        .done[List[Course]] { courses =>
          $.modState(_.copy(courses = courses))
        }.asCallback

    def userButton(implicit state: State): VdomTagOf[Button] =
      <.button(^.cls := "btn btn-primary btn-md", ^.onClick --> getAllUsers)("Get Users")

    def courseButton(implicit state: State): VdomTagOf[Button] =
      <.button(^.cls := "btn btn-success btn-md", ^.onClick --> getAllCourses)("Get Courses")

    def createRow(user: User): VdomTagOf[TableRow] =
      <.tr(
        <.td(user.firstname),
        <.td(user.lastname),
        <.td(user.email),
        <.td(user.phone),
        <.td(user.age)
      )

    def createCourseRow(course: Course): VdomTagOf[TableRow] =
      <.tr(
        <.td(course.name),
        <.td(course.number_of_student),
        <.td(course.price),
        <.td(course.status)
      )

    def userTable(implicit state: State): TagMod =
      <.table(^.cls := "table table-bordered table-striped mt-5")(
        <.thead(<.tr(<.th("First Name"), <.th("Last Name"), <.th("Email"), <.th("Phone"), <.th("Age"))),
        <.tbody(state.users map createRow: _*)).when(state.users.nonEmpty && state.courses.isEmpty)

    def courseTable(implicit state: State): TagMod =
      <.table(^.cls := "table table-bordered table-striped mt-5")(
        <.thead(<.tr(<.th("Name"), <.th("Number of students"), <.th("Price"), <.th("Status"))),
        <.tbody(state.courses map createCourseRow: _*)).when(state.courses.nonEmpty && state.users.isEmpty)

    def render(implicit state: State): VdomTagOf[Div] =
      <.div(userButton, courseButton, userTable, courseTable)
  }

  val AppComponent =
    ScalaComponent.builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  AppComponent().renderIntoDOM(document.getElementById("app"))
}
