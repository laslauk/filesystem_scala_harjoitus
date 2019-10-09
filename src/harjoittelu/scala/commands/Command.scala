package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State

//Basic type for command
trait Command {
  def apply(state: State): State
}

object Command
{
  //factory method kaikille komennoille
  def emptyCommand: Command = ???
  def inCompleteCommand(name: String): Command = ???
  def from(input: String): Command = {

    //mkdir ottaa yhden argumentin
    val tokens: Array[String]  = input.split(" ")

    if(tokens.isEmpty) emptyCommand
    //scalassa ei array accessiä [] vaan () eli tokens.apply(0) tekee uuden lol
    else if ("mkdir".equals(tokens(0))) {
      if (tokens.length < 2) inCompleteCommand("mkdir");
      else new Mkdir(tokens(1))
    }

    new UnknownCommand
  }
}
