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

  object TypeOfAnimalEnum extends Enumeration{
    val Reptile, Bird, Mammal, Amphibian = Value
  }

  object canFlyEnum extends Enumeration{
    val Yes, No, MaybeIfItFalls = Value
  }

  object canSwim extends Enumeration{
    val Yes, No = Value
  }

//  case class Animal(typ: TypeOfAnimalEnum)

  sealed trait Animals

  case object AnimalType extends Animals
  case object Flies extends Animals
  case object Swims extends Animals

}
