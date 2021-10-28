import org.scalajs.dom.document

object Main extends App {
  document.body.id match {
    case "index" => new Example()
    case "user" => new User()
  }
}
