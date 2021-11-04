// @GENERATOR:play-routes-compiler
// @SOURCE:server/conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  HomeController_0: javax.inject.Provider[controllers.HomeController],
  // @LINE:12
  Assets_1: javax.inject.Provider[controllers.Assets],
  // @LINE:13
  webjars_Routes_0: webjars.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    HomeController_0: javax.inject.Provider[controllers.HomeController],
    // @LINE:12
    Assets_1: javax.inject.Provider[controllers.Assets],
    // @LINE:13
    webjars_Routes_0: webjars.Routes
  ) = this(errorHandler, HomeController_0, Assets_1, webjars_Routes_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, webjars_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """@controllers.HomeController@.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """surojiddin""", """@controllers.HomeController@.surojiddin"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test""", """@controllers.HomeController@.test"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """@controllers.HomeController@.userPage"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """@controllers.HomeController@.getUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """navbar""", """@controllers.HomeController@.navbar"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chatD""", """@controllers.HomeController@.chatD"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """game""", """@controllers.HomeController@.game"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """prizes""", """@controllers.HomeController@.getPrizes"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """@controllers.Assets@.versioned(path:String = "/public", file:Asset)"""),
    prefixed_webjars_Routes_0_10.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.get.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_HomeController_surojiddin1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("surojiddin")))
  )
  private[this] lazy val controllers_HomeController_surojiddin1_invoker = createInvoker(
    HomeController_0.get.surojiddin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "surojiddin",
      Nil,
      "GET",
      this.prefix + """surojiddin""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_HomeController_test2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test")))
  )
  private[this] lazy val controllers_HomeController_test2_invoker = createInvoker(
    HomeController_0.get.test,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "test",
      Nil,
      "GET",
      this.prefix + """test""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_HomeController_userPage3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_HomeController_userPage3_invoker = createInvoker(
    HomeController_0.get.userPage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "userPage",
      Nil,
      "GET",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HomeController_getUsers4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_HomeController_getUsers4_invoker = createInvoker(
    HomeController_0.get.getUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_navbar5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("navbar")))
  )
  private[this] lazy val controllers_HomeController_navbar5_invoker = createInvoker(
    HomeController_0.get.navbar,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "navbar",
      Nil,
      "GET",
      this.prefix + """navbar""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_chatD6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chatD")))
  )
  private[this] lazy val controllers_HomeController_chatD6_invoker = createInvoker(
    HomeController_0.get.chatD,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "chatD",
      Nil,
      "GET",
      this.prefix + """chatD""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_game7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("game")))
  )
  private[this] lazy val controllers_HomeController_game7_invoker = createInvoker(
    HomeController_0.get.game,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "game",
      Nil,
      "GET",
      this.prefix + """game""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_getPrizes8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("prizes")))
  )
  private[this] lazy val controllers_HomeController_getPrizes8_invoker = createInvoker(
    HomeController_0.get.getPrizes,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getPrizes",
      Nil,
      "GET",
      this.prefix + """prizes""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_1.get.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] val prefixed_webjars_Routes_0_10 = Include(webjars_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "webjars"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.get.index)
      }
  
    // @LINE:3
    case controllers_HomeController_surojiddin1_route(params@_) =>
      call { 
        controllers_HomeController_surojiddin1_invoker.call(HomeController_0.get.surojiddin)
      }
  
    // @LINE:4
    case controllers_HomeController_test2_route(params@_) =>
      call { 
        controllers_HomeController_test2_invoker.call(HomeController_0.get.test)
      }
  
    // @LINE:5
    case controllers_HomeController_userPage3_route(params@_) =>
      call { 
        controllers_HomeController_userPage3_invoker.call(HomeController_0.get.userPage)
      }
  
    // @LINE:6
    case controllers_HomeController_getUsers4_route(params@_) =>
      call { 
        controllers_HomeController_getUsers4_invoker.call(HomeController_0.get.getUsers)
      }
  
    // @LINE:7
    case controllers_HomeController_navbar5_route(params@_) =>
      call { 
        controllers_HomeController_navbar5_invoker.call(HomeController_0.get.navbar)
      }
  
    // @LINE:8
    case controllers_HomeController_chatD6_route(params@_) =>
      call { 
        controllers_HomeController_chatD6_invoker.call(HomeController_0.get.chatD)
      }
  
    // @LINE:9
    case controllers_HomeController_game7_route(params@_) =>
      call { 
        controllers_HomeController_game7_invoker.call(HomeController_0.get.game)
      }
  
    // @LINE:10
    case controllers_HomeController_getPrizes8_route(params@_) =>
      call { 
        controllers_HomeController_getPrizes8_invoker.call(HomeController_0.get.getPrizes)
      }
  
    // @LINE:12
    case controllers_Assets_versioned9_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_1.get.versioned(path, file))
      }
  
    // @LINE:13
    case prefixed_webjars_Routes_0_10(handler) => handler
  }
}
