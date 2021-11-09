import org.scalajs.dom.document

object Main extends App {
  document.body.id match {
    case "index" => new Example()
    case "user" => new UserApp()
    case "navbar" => new Navbar()
    case "chatD" => new ChatD()
    case "game" => new Game()
  }
}
