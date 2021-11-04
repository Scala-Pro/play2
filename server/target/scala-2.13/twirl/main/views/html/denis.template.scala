
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

/**/
class denis @javax.inject.Inject() /*1.6*/(webJarsUtil: org.webjars.play.WebJarsUtil) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(role: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/main("Denis Page", webJarsUtil)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<table style="color: white; border: 1px solid white;">
    """),_display_(/*5.6*/if(role == "admin")/*5.25*/{_display_(Seq[Any](format.raw/*5.26*/("""
    """),format.raw/*6.5*/("""<tr>
        <th>№</th>
        <th>Name</th>
        <th>Group</th>
        <th>Direction</th>
        <th>Day</th>
    </tr>

    <tr>
        <td>1</td>
        <td>Denis</td>
        <td>850</td>
        <td>Scala</td>
        <td>3</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Dilshod</td>
        <td>851</td>
        <td>Java</td>
        <td>5</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Ogabek</td>
        <td>852</td>
        <td>Python</td>
        <td>7</td>
    </tr>
    """)))}),format.raw/*35.6*/("""
"""),format.raw/*36.1*/("""</table>
""")))}))
      }
    }
  }

  def render(role:String): play.twirl.api.HtmlFormat.Appendable = apply(role)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (role) => apply(role)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: server/app/views/denis.scala.html
                  HASH: 73863b092209d26ece84d36a6b9de31ddecf4c07
                  MATRIX: 473->5|807->50|915->66|954->97|993->99|1020->100|1105->160|1132->179|1170->180|1201->185|1739->693|1767->694
                  LINES: 19->1|22->2|27->3|27->3|27->3|28->4|29->5|29->5|29->5|30->6|59->35|60->36
                  -- GENERATED --
              */
          