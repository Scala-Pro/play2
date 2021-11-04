
package views.html.user

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
class user @javax.inject.Inject() /*1.6*/(webJarsUtil: org.webjars.play.WebJarsUtil) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/user/*3.6*/.main("Home Page", webJarsUtil)/*3.37*/ {_display_(Seq[Any](format.raw/*3.39*/("""
"""),format.raw/*4.1*/("""<div class="container">
    <div class="row">
        <div class="col-md-12 text-center mt-4">
            <h3>User List</h3>
        </div>
        <div class="offset-2 col-md-8">
            <div id="app"></div>
        </div>
    </div>

</div>
<script src="""),_display_(/*15.14*/routes/*15.20*/.Assets.versioned("client-fastopt-bundle.js")),format.raw/*15.65*/("""></script>
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
                  SOURCE: server/app/views/user/user.scala.html
                  HASH: df9cd94fe7040fae22e2c038fe9f70480b0b71dd
                  MATRIX: 477->5|804->50|900->54|911->58|950->89|989->91|1016->92|1304->353|1319->359|1385->404
                  LINES: 19->1|22->2|27->3|27->3|27->3|27->3|28->4|39->15|39->15|39->15
                  -- GENERATED --
              */
          