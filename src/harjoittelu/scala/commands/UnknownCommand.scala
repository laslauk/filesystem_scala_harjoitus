package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State

class UnknownCommand extends Command {
  override def apply(state: State): State = {
    state.setMessage("Command not found :(!")
  }
}
