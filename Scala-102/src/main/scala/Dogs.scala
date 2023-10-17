object Dogs extends App{
  case class Dog(val name: String, val breed: String, val age: Int)
  case class Bird(val name: String, val birdType: String)
  case class Cat(val name: String, val colour: String)

  val a: Dog = Dog("A", "Sausage", 4)
  val b: Dog = Dog("B", "Spotted", 3)
  val c: Dog = Dog("C", "Brown", 2)
  val d: Dog = Dog("D", "Small", 5)

  val tubby: Cat = Cat(name = "Tubby", colour= "Orange")
  val hairy: Cat = Cat(name = "Hairy", colour= "Brown")

  val birdy: Bird = Bird(name="Caw", birdType = "Parrot")

  case class Kennel(val name: String, val dogs: List[Dog], val cats: List[Cat], val birds: List[Bird])

  val ken: Kennel = Kennel(name = "Ken", List(a, b, c, d), List(tubby, hairy), List(birdy))

  val cop_ken: Kennel = ken.copy(name= "Other Name")

  println(cop_ken.name)
}
