import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.util.Random

object GuessWho extends App{
  val rand: scala.util.Random = scala.util.Random
  class Game() {
    class Board(var characterList: List[Character]) {
      def selectRandomCharacter(): Character = {
        Random.shuffle(characterList).head
      }

      def getCharactersFromAttribute(attribute: String, value: String): List[Character] = attribute match{
        case "name" => characterList.filter(_.name == value)
        case "hair" => characterList.filter(_.hair == value)
        case "gender" => characterList.filter(_.gender == value)
        case "glasses" => characterList.filter(_.glasses == value)
        case _ =>
          println("No characters were found with the given attribute and value combination.")
          List()
      }

      def removeCharactersFromGuess(guessAttribute: String, guessValue: String): List[Character] = {
        val charsToRemove = getCharactersFromAttribute(guessAttribute, guessValue)
        characterList.filter(char => !charsToRemove.contains(char))
      }
    }

    class Character(val name: String, val hair: String, val glasses: String, val gender: String)

    def displayCharacterList(characterList: List[Character]): List[Unit] = {
      val padding = "%1$-17s %2$17s %3$17s %4$17s"
      println(s"\n${padding.format("Name", "Hair", "Glasses", "Gender")}")
      characterList.map(x => println(padding.format(x.name, x.hair, x.glasses, x.gender)))
    }

    /**
     * @return a list of character objects using the given attributes
     */
    def createAllCharacters(characterNames: List[String], characterHair: List[String], characterGlasses: List[String], characterGenders: List[String]): List[Character] = {
      @tailrec
      def createCharacter(currCharacterList: List[Character], accum: Int): List[Character] = {
        if (accum == characterNames.length) currCharacterList
        else {
          val newChar = new Character(characterNames.apply(accum), characterHair.apply(accum), characterGlasses.apply(accum), characterGenders.apply(accum))
          createCharacter(currCharacterList :+ newChar, accum + 1)
        }
      }
      createCharacter(List(), 0)
    }

    def playGame(): Unit = {
      val listGuessAttributes: List[String] = List("hair", "name", "glasses", "gender")
//      Define all the characters and their attributes
      val characterNames : List[String] = List("tom cruise", "gal gadot", "michael keaton", "ben affleck", "elizabeth olsen")
      val characterHair : List[String] = List("black", "brown", "grey", "black", "blonde")
      val characterGlasses: List[String] = List("none", "none", "yes", "yes", "none")
      val characterGenders: List[String] = List("male", "female", "male", "male", "female")

//      Create objects from attributes
      val characters: List[Character] = createAllCharacters(characterNames, characterHair, characterGlasses, characterGenders)

      val bd = new Board(characters)

      displayCharacterList(bd.characterList)

      /**
       *
       * @param hiddenCharacter - the character chosen by the random library
       * @param num_guesses - number of guesses player can make before game times out
       * @param state - identify if the player has won
       * @return
       */
      def loopUntilFinish(hiddenCharacter: Character, num_guesses: Int = 3, state: Boolean = false): String = {
        val charsLeft: Int = bd.characterList.length
        if (state || (charsLeft == 1 && (hiddenCharacter.name == bd.characterList.head.name)))
          s"Well done! You guessed my character! I chose ${hiddenCharacter.name} at the start!"
        else if (charsLeft == 0 || !bd.characterList.contains(hiddenCharacter))
          s"I chose ${hiddenCharacter.name} from the board, but you removed them with your guess. You've lost!"
        else if (num_guesses == 0)
          s"Too bad you didn't guess my character in time, they were ${hiddenCharacter.name}"
        else {
          println("Enter a guess attribute:")
          val guessAttr: String = readLine()
          val guessVal: String = guessAttr.toLowerCase().trim() match {
            case x if listGuessAttributes.contains(x) =>
              println("Enter a guess value:")
              readLine().toLowerCase().trim()
            case _ =>
              println("Guess attribute not recognised, let's try again!")
              loopUntilFinish(hiddenCharacter, num_guesses, bd.characterList.length == 1 && bd.characterList.head == hiddenCharacter)
          }

          if (guessAttr == "name" && guessVal == hiddenCharacter.name)
            loopUntilFinish(hiddenCharacter, num_guesses, state = true)
          else {
            bd.characterList = bd.removeCharactersFromGuess(guessAttr.toLowerCase().trim(), guessVal.toLowerCase().trim())
            displayCharacterList(bd.characterList)
            println(s"GUESSES LEFT: ${num_guesses - 1}")
            loopUntilFinish(hiddenCharacter, num_guesses - 1)
          }
        }
      }
      val charToGuess: Character = bd.selectRandomCharacter()
      println(s"I have chosen a character from the above list!")
      println(loopUntilFinish(charToGuess))
    }
  }

  val gm = new Game()
  gm.playGame()
}
