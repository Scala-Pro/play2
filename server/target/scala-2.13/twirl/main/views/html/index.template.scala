
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
class index @javax.inject.Inject() /*1.6*/(webJarsUtil: org.webjars.play.WebJarsUtil) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/main("Home Page", webJarsUtil)/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""
"""),format.raw/*4.1*/("""<br>
<div class="row">
    <div class="offset-3 col-6 bg-white" style="border-radius: 10px">
        <div class="row">
            <div class="col-3">
                <img src="""),_display_(/*9.27*/routes/*9.33*/.Assets.versioned("images/scala.png")),format.raw/*9.70*/(""" """),format.raw/*9.71*/("""width="100px" alt="">
            </div>
            <div class="col-7">
                <div id="app"></div>
            </div>
        </div>
    </div>
</div>
<script src="""),_display_(/*17.14*/routes/*17.20*/.Assets.versioned("client-fastopt-bundle.js")),format.raw/*17.65*/("""></script>
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
                  SOURCE: server/app/views/index.scala.html
                  HASH: ab49363574c3f31f026ce44c78b2e43f2d9d7372
                  MATRIX: 473->5|800->50|896->54|934->84|973->86|1000->87|1203->264|1217->270|1274->307|1302->308|1504->483|1519->489|1585->534
                  LINES: 19->1|22->2|27->3|27->3|27->3|28->4|33->9|33->9|33->9|33->9|41->17|41->17|41->17
                  -- GENERATED --
              */
          