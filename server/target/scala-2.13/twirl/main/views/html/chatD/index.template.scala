
package views.html.chatD

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


Seq[Any](_display_(/*3.2*/chatD/*3.7*/.main("Home Page", webJarsUtil)/*3.38*/ {_display_(Seq[Any](format.raw/*3.40*/("""
"""),format.raw/*4.1*/("""<div id="chatD"></div>
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
                  SOURCE: server/app/views/chatD/index.scala.html
                  HASH: c3d1a157293c56cfb48b3764429be518cbc074ce
                  MATRIX: 479->5|806->50|902->54|914->59|953->90|992->92|1019->93|1081->129|1095->135|1160->180
                  LINES: 19->1|22->2|27->3|27->3|27->3|27->3|28->4|29->5|29->5|29->5
                  -- GENERATED --
              */
          