import GuessWho.Game
import org.scalatest.flatspec.AnyFlatSpec

class GuessWhoTest extends AnyFlatSpec{
  val gm: Game = new Game()

  val characterNames: List[String] = List("Tom Cruise", "Gal Gadot", "Michael Keaton", "Ben Affleck", "Elizabeth Olsen")
  val characterHair: List[String] = List("Black", "Brown", "Grey", "Black", "Blonde")
  val characterGlasses: List[Boolean] = List(false, false, true, true, false)
  val characterGenders: List[String] = List("Male", "Female", "Male", "Male", "Female")

  "Create all characters" should "create all characters given the names and other attributes" in {
    val characters: List[gm.Character] = gm.createAllCharacters(characterNames, characterHair, characterGlasses, characterGenders)
    val bd: GuessWhoTest.this.gm.Board = new gm.Board(characters)
    println("All characters should be displayed here!")
    gm.displayCharacterList(bd.characterList)
  }

  "Get characters without glasses" should "return Tom Cruise, Gal Gadot and Elizabeth Olsen" in {
    val characters: List[gm.Character] = gm.createAllCharacters(characterNames, characterHair, characterGlasses, characterGenders)
    val bd: GuessWhoTest.this.gm.Board = new gm.Board(characters)
    bd.characterList = bd.removeCharactersFromGuess("Glasses", Right(true))
    println("Characters WITHOUT glasses (i.e., glasses = false) should be here!")
    gm.displayCharacterList(bd.characterList)
  }

  "Get remaining characters without glasses and black hair" should "return Gal Gadot and Elizabeth Olsen" in {
    val characters: List[gm.Character] = gm.createAllCharacters(characterNames, characterHair, characterGlasses, characterGenders)
    val bd: GuessWhoTest.this.gm.Board = new gm.Board(characters)
    bd.characterList = bd.removeCharactersFromGuess("Glasses", Right(true))
    bd.characterList = bd.removeCharactersFromGuess("Hair", Left("Black"))
    println("All characters without glasses and black hair")
    gm.displayCharacterList(bd.characterList)
  }

  "Breaking test" should "return something when an incorrect command is passed in" in {
    val characters: List[gm.Character] = gm.createAllCharacters(characterNames, characterHair, characterGlasses, characterGenders)
    val bd: GuessWhoTest.this.gm.Board = new gm.Board(characters)
    bd.characterList = bd.removeCharactersFromGuess("T-shirt", Right(true))
    gm.displayCharacterList(bd.characterList)
  }
}
