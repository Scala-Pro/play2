// @GENERATOR:play-routes-compiler
// @SOURCE:server/conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getStudents: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getStudents",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:11
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.createUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "create-user"})
        }
      """
    )
  
    // @LINE:10
    def getPrizes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getPrizes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prizes"})
        }
      """
    )
  
    // @LINE:7
    def navbar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.navbar",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "navbar"})
        }
      """
    )
  
    // @LINE:12
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "get-user"})
        }
      """
    )
  
    // @LINE:3
    def surojiddin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.surojiddin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "surojiddin"})
        }
      """
    )
  
    // @LINE:9
    def game: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.game",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "game"})
        }
      """
    )
  
    // @LINE:4
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test"})
        }
      """
    )
  
    // @LINE:8
    def chatD: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.chatD",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chatD"})
        }
      """
    )
  
    // @LINE:5
    def userPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.userPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
