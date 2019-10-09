package harjoittelu.scala.commands
import harjoittelu.scala.filesystem.State
import harjoittelu.scala.files.Directory
import harjoittelu.scala.files.DirEntry


class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    //1. receive working directory from the current state
    val wd = state.wd

    if( wd.hasEntry(name)) {
      state.setMessage(("Entry " + name + " already exists!"));
    } else if (name.contains(Directory.SEPARATOR)) {
      //Dont allow / separator in command
      state.setMessage(name + " must not contain separator symbol!");
    } else if (checkIllegalName(name)){
    state.setMessage(name + " Illegal entry name!");
    } else {
      doMkdir(state, name) //otetaan vanha state
    }

  }

  def checkIllegalName(name: String): Boolean = {
     name.contains(".");
  }

  def doMkdir(state: State, name: String): State = {

    def updateStructure(currentDirectory: Directory,
                        path: List[String],
                        newEntry: Directory): Directory = {

      if(path.isEmpty) currentDirectory.addEntry(newEntry) //end      //Finishing statement

      else {
          val oldEntry = currentDirectory.findEntry(path.head).asDirectory
          currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }

    }

    val wd = state.wd;

    val allDirsInPath = wd.getAllFoldersInPath
    val newDir = Directory.empty(wd.path, name)

    //get all directories in the full path
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)
    //create new directory entry in the wd
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot,newWd);

    //update the directory structure starting from the root

    //find new working directory instance given wds full path in the NEW dir structure


  }

}
