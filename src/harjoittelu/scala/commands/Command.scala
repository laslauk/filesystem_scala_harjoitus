package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State

//Basic type for command
trait Command {
  def apply(state: State): State
}
