
package views.html.game

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


Seq[Any](_display_(/*3.2*/game/*3.6*/.main("Game", webJarsUtil)/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""
"""),format.raw/*4.1*/("""<div id="app-game"></div>
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
                  SOURCE: server/app/views/game/index.scala.html
                  HASH: a06d602879421fa1b1d78fab946bb3177fa38130
                  MATRIX: 478->5|805->50|901->54|912->58|946->84|985->86|1012->87|1077->126|1091->132|1156->177
                  LINES: 19->1|22->2|27->3|27->3|27->3|27->3|28->4|29->5|29->5|29->5
                  -- GENERATED --
              */
          