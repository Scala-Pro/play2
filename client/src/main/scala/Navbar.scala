import Protocol._
import japgolly.scalajs.react.component.Scala.{BackendScope, Component}
import japgolly.scalajs.react.facade.SyntheticFormEvent
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, CtorType, ScalaComponent}
import org.scalajs.dom.document
import org.scalajs.dom.html.{Div, Element, TableRow}
import org.scalajs.dom.raw.HTMLInputElement
import protocols._

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Navbar")
class Navbar extends AjaxImplicits {

  type AppComponentType = Component[Unit, State, Backend, CtorType.Nullary]

  case class State(
    name: String = "",
    email: String = "",
    phone: String = "",
    workersCount: Int = 0,
    companies: List[Company] = Nil,
    page: Page = Home
  )



  class Backend($ : BackendScope[Unit, State]) {

    def changePage(selectedPage: Page): Callback =
      $.modState(_.copy(page = selectedPage))

    def navbar(implicit state: State): TagMod =
      <.nav(
        ^.className := "navbar navbar-expand-lg navbar-light bg-light",
        <.div(
          ^.className := "container-fluid",
          <.a(^.className := "navbar-brand", ^.href := "#", "Navbar"),
          <.button(
            ^.className                := "navbar-toggler",
            ^.`type`                   := "button",
            VdomAttr("data-bs-toggle") := "collapse",
            VdomAttr("data-bs-target") := "#navbarNav",
            VdomAttr("aria-controls")  := "navbarNav",
            VdomAttr("aria-expanded")  := "false",
            VdomAttr("aria-label")     := "Toggle navigation",
            <.span(^.className := "navbar-toggler-icon")
          ),
          <.div(
            ^.className := "collapse navbar-collapse",
            ^.id        := "navbarNav",
            <.ul(
              ^.className := "navbar-nav",
              <.li(
                ^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls      := "active").when(state.page == Home),
                  ^.onClick --> changePage(Home)
                )("Home")
              ),
              <.li(
                ^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls      := "active").when(state.page == CompanyForm),
                  ^.onClick --> changePage(CompanyForm)
                )("Company")
              ),
              <.li(
                ^.className := "nav-item",
                <.a(
                  ^.className := "nav-link",
                  (^.cls      := "active").when(state.page == CompanyDashboard),
                  ^.onClick --> changePage(CompanyDashboard)
                )("Companies")
              )
            )
          )
        )
      )

    def getAllCompanies: Callback =
      get(Urls.GetCompanyUrl)
        .fail(onError)
        .done[List[Company]] { company =>
          $.modState(_.copy(companies = company))
        }
        .asCallback
    getAllCompanies.runNow()

    def onChangeWorkersCount(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(workersCount = event.target.value.toInt))

    def onChangeName(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(name = event.target.value))

    def onChangeEmail(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(email = event.target.value))

    def onChangePhone(event: SyntheticFormEvent[HTMLInputElement]): Callback =
      $.modState(_.copy(phone = event.target.value))

    def onSubmit(implicit state: State): Callback = {
      val company = CompanyWithoutId(state.name, state.email, state.phone, state.workersCount)
      post[CompanyWithoutId]("/company", company)
        .fail(onError)
        .done[Company] { company =>
          $.modState(s => s.copy(companies = state.companies :+ company)) >>
            Callback.alert("Successfully created")
        }
        .asCallback
    }

    def homePage(implicit state: State): TagMod =
      <.div("Home page.").when(state.page == Home)

    def companyForm(implicit state: State): TagMod =
      <.div(^.cls := "row")(
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Company name:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeName)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Email:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangeEmail)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Phone:"),
            <.input(^.cls := "form-control", ^.onChange ==> onChangePhone)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.div(^.cls := "form-group")(
            <.label(^.cls := "form-label")("Workers count:"),
            <.input(^.`type` := "number", ^.cls := "form-control", ^.onChange ==> onChangeWorkersCount)
          )
        ),
        <.div(^.cls := "col-6 offset-3")(
          <.button(^.cls := "btn btn-success")("Submit", ^.onClick --> onSubmit)
        )
      ).when(state.page == CompanyForm)

    def createRow(company: Company): VdomTagOf[TableRow] =
      <.tr(
        <.td(company.name),
        <.td(company.email),
        <.td(company.phone),
        <.td(company.workerCount)
      )

    def companyTable(implicit state: State): TagMod =
      <.table(^.cls := "table table-bordered table-striped mt-5")(
        <.thead(<.tr(<.th("Name"), <.th("Email"), <.th("Phone"), <.th("Workers count"))),
        <.tbody(state.companies map createRow: _*)
      ).when(state.page == CompanyDashboard)

    def render(implicit state: State): VdomTagOf[Div] =
      <.div(^.cls := "container")(navbar, homePage, companyForm, companyTable)
  }

  val NavbarComponent: AppComponentType =
    ScalaComponent
      .builder[Unit]
      .initialState(State())
      .renderBackend[Backend]
      .build

  NavbarComponent().renderIntoDOM(document.getElementById("navbar-app"))
}
