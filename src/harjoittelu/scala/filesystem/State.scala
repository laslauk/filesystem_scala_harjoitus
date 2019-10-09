package harjoittelu.scala.filesystem
import harjoittelu.scala.files.Directory

class State(val root: Directory, val wd: Directory, val output:  String) {

  def show: Unit = {
    print(output)
    print(State.SHELL_TOKEN)
  }

  def setMessage(message: String): State =
    State(root, wd, message); //kutsuu apply methodia alhaalla samat root ja wd ja uus mesage
}

object State {
  val SHELL_TOKEN = "$ "
  def apply(root: Directory, wd: Directory, output: String = ""): State =
    new State(root, wd, output)
}
