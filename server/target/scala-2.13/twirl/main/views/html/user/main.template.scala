
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
    """),_display_(/*10.6*/webJarsUtil/*10.17*/.locate("css/bootstrap.css").css()),format.raw/*10.51*/("""
  """),format.raw/*11.3*/("""</head>
  <body id="user">
    """),_display_(/*13.6*/content),format.raw/*13.13*/("""
  """),format.raw/*14.3*/("""</body>
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
                  SOURCE: server/app/views/user/main.scala.html
                  HASH: 76d6b676788100611ed3b7580d92228753eaf0b5
                  MATRIX: 437->1|800->28|967->102|1047->156|1072->161|1328->391|1348->402|1403->436|1433->439|1491->471|1519->478|1549->481
                  LINES: 17->1|22->2|27->3|30->6|30->6|34->10|34->10|34->10|35->11|37->13|37->13|38->14
                  -- GENERATED --
              */
          