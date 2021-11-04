
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,org.webjars.play.WebJarsUtil,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, webJarsUtil: org.webjars.play.WebJarsUtil)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <title>"""),_display_(/*5.13*/title),format.raw/*5.18*/("""</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    """),_display_(/*9.6*/webJarsUtil/*9.17*/.locate("css/bootstrap.css").css()),format.raw/*9.51*/("""
  """),format.raw/*10.3*/("""</head>
  <body id="navbar">
    """),_display_(/*12.6*/content),format.raw/*12.13*/("""
  """),format.raw/*13.3*/("""</body>
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
                  SOURCE: server/app/views/navbar/main.scala.html
                  HASH: 1a21142e27b3d963d5907bc6cea783402e75b4ad
                  MATRIX: 769->1|936->75|1016->129|1041->134|1296->364|1315->375|1369->409|1399->412|1459->446|1487->453|1517->456
                  LINES: 21->1|26->2|29->5|29->5|33->9|33->9|33->9|34->10|36->12|36->12|37->13
                  -- GENERATED --
              */
          