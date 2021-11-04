
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
/*1.2*/import controllers.routes

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,org.webjars.play.WebJarsUtil,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(title: String, webJarsUtil: org.webjars.play.WebJarsUtil)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <title>"""),_display_(/*6.13*/title),format.raw/*6.18*/("""</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.min.css">
    <link rel="stylesheet" href="""),_display_(/*11.34*/routes/*11.40*/.Assets.versioned("styles/chat.css")),format.raw/*11.76*/(""">
    """),_display_(/*12.6*/webJarsUtil/*12.17*/.locate("css/bootstrap.css").css()),format.raw/*12.51*/("""
  """),format.raw/*13.3*/("""</head>
  <body id="chatD">
    """),_display_(/*15.6*/content),format.raw/*15.13*/("""
  """),format.raw/*16.3*/("""</body>
</html>"""))
      }
    }
  }

  def render(title:String,webJarsUtil:org.webjars.play.WebJarsUtil,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,webJarsUtil)(content)

  def f:((String,org.webjars.play.WebJarsUtil) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,webJarsUtil) => (content) => apply(title,webJarsUtil)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: server/app/views/chatD/main.scala.html
                  HASH: 6484aa09317f1b7bf539bd0af75ce2d069751a07
                  MATRIX: 438->1|801->28|968->102|1048->156|1073->161|1501->562|1516->568|1573->604|1606->611|1626->622|1681->656|1711->659|1770->692|1798->699|1828->702
                  LINES: 17->1|22->2|27->3|30->6|30->6|35->11|35->11|35->11|36->12|36->12|36->12|37->13|39->15|39->15|40->16
                  -- GENERATED --
              */
          