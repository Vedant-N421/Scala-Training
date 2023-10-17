object Taxing extends App{
  def calculateTax(cost: Int): Double = cost match {
    case x if x > 100000 => x * 0.4
    case x if x > 50000 => x * 0.2
    case x if x > 10000 => x * 0.15
    case x => x * 0.1
  }
  def funcCalculateTax: Int => Double = {
    case x if x > 100000 => x * 0.4
    case x if x > 50000 => x * 0.2
    case x if x > 10000 => x * 0.15
    case x => x * 0.1
  }
}
