package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State
import harjoittelu.scala.files.DirEntry
import harjoittelu.scala.files.Directory

class Ls extends Command {

  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceoutput(contents)
    state.setMessage(niceOutput)
  }

  def createNiceoutput(contents: List[DirEntry]): String = {
      if(contents.isEmpty) ""
    else {
        val entry = contents.head
        entry.name + "[" + entry.getType + "]" + "\n" + createNiceoutput(contents.tail)

      }
  }
}
