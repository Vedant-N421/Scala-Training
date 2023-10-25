

object FinalPractical {

  object temp extends Enumeration{
    val Hot, Cold = Value
  }
  trait MenuItem {
    val name: String
    val cost: BigDecimal
    val temperature: temp.Value
    val isDrink: Boolean
    val isPremium: Boolean
  }

  case class Cola() extends MenuItem{
    override val name: String = "Cola"
    override val cost: BigDecimal = 0.5
    override val temperature: temp.Value = temp.Cold
    override val isDrink: Boolean = true
    override val isPremium: Boolean = false
  }

  case class Coffee() extends MenuItem {
    override val name: String = "Coffee"
    override val cost: BigDecimal = 1
    override val temperature: temp.Value = temp.Hot
    override val isDrink: Boolean = true
    override val isPremium: Boolean = false
  }

  case class CheeseSandwich() extends MenuItem {
    override val name: String = "Cheese Sandwich"
    override val cost: BigDecimal = 2
    override val temperature: temp.Value = temp.Cold
    override val isDrink: Boolean = false
    override val isPremium: Boolean = false
  }

  case class SteakSandwich() extends MenuItem {
    override val name: String = "Steak Sandwich"
    override val cost: BigDecimal = 4.5
    override val temperature: temp.Value = temp.Hot
    override val isDrink: Boolean = false
    override val isPremium: Boolean = false
  }

  case class Lobster() extends MenuItem {
    override val name: String = "Lobster"
    override val cost: BigDecimal = 25
    override val temperature: temp.Value = temp.Hot
    override val isDrink: Boolean = false
    override val isPremium: Boolean = true
  }

  val getTotalBill: (List[MenuItem], Int) => BigDecimal = (bill, loyaltyPoints) => bill.map {
    case f@x if x.isPremium => f.cost
    case f => f.cost * loyaltyDiscount(loyaltyPoints)
  }.sum

  val loyaltyDiscount: Int => BigDecimal = {
    case x if x < 3 => 1
    case y if y > 8 => 1 - (0.025 * 8)
    case starCount => 1 - (0.025 * starCount)
  }

  val getBill: (List[MenuItem], Int) => BigDecimal = (bill, loyaltyPoints) => bill match{
    case x if bill.exists(item => item.isPremium) => getTotalBill(bill, loyaltyPoints) + (getTotalBill(bill, loyaltyPoints) * 0.25).min(40)
    case y if bill.exists(item => item.temperature == temp.Hot && !item.isDrink) => getTotalBill(bill, loyaltyPoints) + (getTotalBill(bill, loyaltyPoints) * 0.2).min(20)
    case z if bill.exists(item => !item.isDrink) => getTotalBill(bill, loyaltyPoints) + (getTotalBill(bill, loyaltyPoints) * 0.1)
    case _ => getTotalBill(bill, loyaltyPoints)
  }

//  def foobar: Int = 3
//  def foobar_=(value: Int): Unit = println(234)
//
//  def unary_! : Int = 3
//
//  def blabla_:(value: Int): Int = value
//}
//
//object Fooo extends App {
//
//  final case class
//
//  println(12 :: 13 :: Nil)
//
//  println(12 - 33 - 44)
//
//  FinalPractical.foobar = 333
//  println(FinalPractical.foobar)
//  println(333 blabla_: FinalPractical)
//  println(FinalPractical.blabla_:(333))
//
//  FinalPractical blabla 3
//  FinalPractical.blabla(3)
//}

//object MainRunnable {
//  def main(args: Array[String]): Unit = {
//    val testShoppingList: List[MenuItem] = List(Cola(), SteakSandwich())
//    println(f"The total is: £${getBill(testShoppingList, 3).setScale(2, BigDecimal.RoundingMode.HALF_UP)}")
//  }
}
