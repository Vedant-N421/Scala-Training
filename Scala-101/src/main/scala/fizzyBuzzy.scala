object fizzyBuzzy extends App{
  def fizzBuzz(x: Int): String = x match {
    case n if n > 0 && n % 5 == 0 && n % 3 == 0 => "FizzBuzz"
    case n if n > 0 && n % 3 == 0 => "Fizz"
    case n if n > 0 && n % 5 == 0 => "Buzz"
    case _ => ""
  }
}
