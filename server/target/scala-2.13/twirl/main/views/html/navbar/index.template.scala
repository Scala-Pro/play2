
package views.html.navbar

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
class index @javax.inject.Inject() /*1.6*/(webJarsUtil: org.webjars.play.WebJarsUtil) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/navbar/*3.8*/.main("Navbar Example", webJarsUtil)/*3.44*/ {_display_(Seq[Any](format.raw/*3.46*/("""
"""),format.raw/*4.1*/("""<div id="navbar-app"></div>
<script src="""),_display_(/*5.14*/routes/*5.20*/.Assets.versioned("client-fastopt-bundle.js")),format.raw/*5.65*/("""></script>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: server/app/views/navbar/index.scala.html
                  HASH: 75ff5bb02ea26272293609195c41c46d863cf737
                  MATRIX: 480->5|807->50|903->54|916->60|960->96|999->98|1026->99|1093->140|1107->146|1172->191
                  LINES: 19->1|22->2|27->3|27->3|27->3|27->3|28->4|29->5|29->5|29->5
                  -- GENERATED --
              */
          