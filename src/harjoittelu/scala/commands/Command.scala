package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State

//Basic type for command
trait Command {
  def apply(state: State): State
}

object Command
{
  val MKDIR = "mkdir"

  //factory method kaikille komennoille
  def emptyCommand: Command = new Command { //anonymous class
    override def apply(state:State): State = state
  }

  def inCompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(name + ": incomplete command!");
  }
  def from(input: String): Command = {


    //mkdir ottaa yhden argumentin
    val tokens: Array[String]  = input.split(" ")

    if(input.isEmpty || tokens.isEmpty) emptyCommand
    //scalassa ei array accessiä [] vaan () eli tokens.apply(0) tekee uuden lol
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) {
        inCompleteCommand(MKDIR)
      };
      else  {
        new Mkdir(tokens(1))
      }
    } else {
      new UnknownCommand
    }

  }
}
