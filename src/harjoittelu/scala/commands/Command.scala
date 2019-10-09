package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State

//Basic type for command
trait Command {
  def apply(state: State): State
}

object Command
{
  //factory method
  def from(input: String): Command = {
    new UnknownCommand
  }
}
