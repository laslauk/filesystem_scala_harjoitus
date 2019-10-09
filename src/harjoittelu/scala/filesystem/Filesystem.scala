package harjoittelu.scala.filesystem
import java.util.Scanner
import harjoittelu.scala.files.Directory
import harjoittelu.scala.commands.Command

object Filesystem extends App {

  //input system
  val scanner = new Scanner(System.in)
  val root = Directory.ROOT

  //HUOM, toistaiseksi NON-functional
  var state = State(root, root) //STATEFUL APP, tarvitaan VAR eikä Val, val ei voi muuttaa

  //main loop
  while(true) {
    state.show
    val input = scanner.nextLine() //take user input

    //command palauttaa uuden commandin based on user input ja kutsuu sen applyä joka
    // palauttaa uuden staten, IMMUTABILITY ja silleen t: Geral of Rivia
    state =  Command.from(input).apply(state);
  }

}
