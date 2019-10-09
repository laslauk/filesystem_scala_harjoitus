package harjoittelu.scala.files
import harjoittelu.scala.files.Directory
abstract class DirEntry(val parentPath: String, val name: String) {
  def path : String = parentPath + Directory.SEPARATOR + name
  def asDirectory: Directory;
}
