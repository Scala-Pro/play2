
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
    <link rel="stylesheet" href="""),_display_(/*10.34*/routes/*10.40*/.Assets.versioned("styles/game.css")),format.raw/*10.76*/(""">
    """),_display_(/*11.6*/webJarsUtil/*11.17*/.locate("css/bootstrap.css").css()),format.raw/*11.51*/("""
  """),format.raw/*12.3*/("""</head>
  <body id="game">
    """),_display_(/*14.6*/content),format.raw/*14.13*/("""
  """),format.raw/*15.3*/("""</body>
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
                  SOURCE: server/app/views/game/main.scala.html
                  HASH: 02dc99005e7e4a40b62da7d07b7ed91077d9b1f6
                  MATRIX: 437->1|800->28|967->102|1047->156|1072->161|1357->419|1372->425|1429->461|1462->468|1482->479|1537->513|1567->516|1625->548|1653->555|1683->558
                  LINES: 17->1|22->2|27->3|30->6|30->6|34->10|34->10|34->10|35->11|35->11|35->11|36->12|38->14|38->14|39->15
                  -- GENERATED --
              */
          