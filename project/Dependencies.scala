import sbt._
object Dependencies {
  object Versions {
    val cats          = "2.6.1"
    val scalaLogging  = "3.9.2"
    val logBack       = "1.2.3"
    val logOver       = "1.7.30"
    val playWebjars   = "2.8.0-1"
    val bootstrap     = "5.1.2"
    val reactJsV      = "17.0.2"
    val scalaJsReactV = "2.0.0-RC3"
    val scalaCssV     = "0.8.0-RC1"
    val circeVersion  = "0.14.1"
    val specs2Version = "5.0.0-RC-15"
  }

  object Libraries {
    val cats         = "org.typelevel"              %% "cats-core"     % Versions.cats
    val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % Versions.scalaLogging

    val logBackLibs: Seq[ModuleID] = Seq(
      "ch.qos.logback" % "logback-core"    % Versions.logBack,
      "ch.qos.logback" % "logback-classic" % Versions.logBack % Test)

    val webjarsLibs: Seq[ModuleID] =
      Seq("org.webjars" %% "webjars-play" % Versions.playWebjars, "org.webjars" % "bootstrap" % Versions.bootstrap)

    val npmLibs = Seq("react" -> Versions.reactJsV, "react-dom" -> Versions.reactJsV)

    val circeLibs = Seq(
      "io.circe" %% "circe-core"    % Versions.circeVersion,
      "io.circe" %% "circe-parser"  % Versions.circeVersion,
      "io.circe" %% "circe-generic" % Versions.circeVersion)

  }
  val rootDependencies: Seq[ModuleID] = Seq(Libraries.cats, Libraries.scalaLogging) ++
    Libraries.logBackLibs ++
    Libraries.webjarsLibs
}
