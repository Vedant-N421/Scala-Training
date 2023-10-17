object Options extends App{
  case class chocolateBar(filling: Option[String])

  def getFilling(bar: chocolateBar): String = bar.filling.getOrElse("Chocolate all the way!")

  val a: chocolateBar = chocolateBar(Some("Coconut"))
  val b: chocolateBar = chocolateBar(None)

  println(getFilling(a))
  println(getFilling(b))

  case class Dog(name: Option[String], age: Option[Int], colour: Option[String], spotColour: Option[String])

  def getSpotColour(dog: Dog): String = dog.spotColour.getOrElse("No spots")
  def getSpotColourMatch(dog: Dog): String = dog.spotColour match {
    case Some(x) => x
    case None => "No spots"
  }

//  def doubleIt(x: Option[Int]): Int = x match {
//    case Some(i) => i * 2
//    case None => None
//  }

  def doubleIt(x: Option[Int]): Int = x.get * 2

  val e: Dog = Dog(name = Some("Sam"), age = Some(34), colour = None, spotColour = Some("black"))
  val f: Dog = Dog(name = None, age = Some(23), colour = None, spotColour = None)
  val c: Int = doubleIt(Some(4))
  val d: Int = doubleIt(None)

}
