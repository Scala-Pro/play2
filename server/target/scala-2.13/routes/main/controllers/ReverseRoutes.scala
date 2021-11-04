// @GENERATOR:play-routes-compiler
// @SOURCE:server/conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getStudents: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:11
    def createUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "create-user")
    }
  
    // @LINE:10
    def getPrizes: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "prizes")
    }
  
    // @LINE:7
    def navbar: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "navbar")
    }
  
    // @LINE:12
    def getUsers: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get-user")
    }
  
    // @LINE:3
    def surojiddin: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "surojiddin")
    }
  
    // @LINE:9
    def game: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "game")
    }
  
    // @LINE:4
    def test: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "test")
    }
  
    // @LINE:8
    def chatD: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chatD")
    }
  
    // @LINE:5
    def userPage: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:2
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
