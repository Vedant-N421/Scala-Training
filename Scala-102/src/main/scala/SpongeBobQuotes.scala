import scala.util.Random

object SpongeBobQuotes extends App{
  val spongeQuote: Option[String] => String = {
    case Some("spongebob") => "I love flipping patties"
    case Some("patrick") => "I am a starfish"
    case Some("krabs") => "Money money money"
    case Some("plankton") => "Secret ingredient required"
    case None => "This is a default quote"
  }

  val someQuote: Option[String] => String = {
    case Some(x) => x
    case None =>
      val quotes = List("The unexamined life is not worth living", "Whereof one cannot speak, thereof one must be silent", "Entities should not be multiplied unnecessarily", "The life of man (in a state of nature) is solitary, poor, nasty, brutish, and short")
      val rand = new Random
      quotes.apply(rand.nextInt(quotes.length))
  }

  val funcHOF: ((Option[String] => String), Option[String]) => String = (func, quote) => func(quote)

  println(funcHOF(spongeQuote, Some("krabs")))
  println(funcHOF(spongeQuote, None))
  println(funcHOF(someQuote, Some("to be")))
  println(funcHOF(someQuote, None))

}
