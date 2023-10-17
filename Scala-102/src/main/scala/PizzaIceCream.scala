object PizzaIceCream extends App{
  sealed trait Flavour

  def GetIceCreamFlavour(generalFlav: String): String = generalFlav match{
    case "Caramel" => "caramel chew chew"
    case "Chocolate" => "chocolate fudge brownie"
    case "Cookie" => "cookie dough"
    case _ => "original"
  }

  println(GetIceCreamFlavour("Strawberry"))
  println(GetIceCreamFlavour("Chocolate"))
  println(GetIceCreamFlavour("Cookie"))


  class PizzaOptions(val crust: List[String])
  case class Pizza(size: Int, crust: String)

  case class Personal(size: Int = 7) extends PizzaOptions(List("classic"))
  case class Small(size: Int = 9) extends PizzaOptions(List("classic", "italian"))
  case class Medium(size: Int = 11) extends PizzaOptions(List("classic", "italian", "stuffed"))
  case class Large(size: Int = 13) extends PizzaOptions(List("classic", "italian", "stuffed"))

  def addStuffedPrice(pizza:Pizza): Double = {
    if (pizza.crust == "stuffed" && (pizza.size == 11 || pizza.size == 13)) 2.99 else 0
  }


  def getPrice(pizza: Pizza): Double = {
    val init_price: Double = pizza.size match {
      case 7 => 5.99
      case 9 => 10.99
      case 11 => 12.99
      case 13 => 14.99
    }
    init_price + addStuffedPrice(pizza)
  }

  val a: Pizza = Pizza(7, "classic")
//  The below should just bill the price of a small
  val b: Pizza = Pizza(7, "stuffed")
  val c: Pizza = Pizza(11, "italian")
//  Should return £12.99 + £2.99
  val d: Pizza = Pizza(11, "stuffed")

  println(getPrice(a))
  println(getPrice(b))
  println(getPrice(c))
  println(getPrice(d))

}

