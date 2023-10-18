object Enums extends App{
  object Nintendo extends Enumeration {
    val Mario, Luigi, Peach, Bowser, Toad, DonkeyKong, Koopa, Goomba = Value
  }
  sealed trait Nintendo
  case object Mario extends Nintendo
  case object Luigi extends Nintendo
  case object Peach extends Nintendo
  case object Bowser extends Nintendo
  case object Toad extends Nintendo
  case object DonkeyKong extends Nintendo
  case object Koopa extends Nintendo
  case object Goomba extends Nintendo

  val ls: List[Nintendo] = List(Mario, Luigi, Peach, Bowser, Toad, DonkeyKong, Koopa, Goomba)

  ls.foreach(x => println(x.toString))

  case class Tiger()

  object TypeOfAnimalEnum extends Enumeration{
    val Reptile, Bird, Mammal, Amphibian = Value
  }

  object CanFlyEnum extends Enumeration{
    val Yes, No, Maybe = Value
  }

  object CanDrown extends Enumeration{
    val Yes, No = Value
  }

  sealed trait Animal

  case object Tiger extends Animal
  case object Lion extends Animal
  case object Cat extends Animal

  val tiger = Tiger()

}
