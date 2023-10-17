object Capitals extends App{
  def isCapitalCity(city: String): String = city.toLowerCase() match{
    case "london" => "London"
    case "edinburgh" => "Edinburgh"
    case "cardiff" => "Cardiff"
    case "belfast" => "Belfast"
    case _ => city
  }

  println(isCapitalCity("MUMBAI"))
  println(isCapitalCity("LONDON"))
  println(isCapitalCity("cardiff"))

  abstract class Animal(val name: String, val age: Int)

  case class Dog(override val name: String, override val age: Int) extends Animal(name, age)
  case class Cat(override val name: String, override val age: Int) extends Animal(name, age)

  def checkDogOrCat(pet: Animal): String = pet match {
    case dog: Dog => "Dog"
    case cat: Cat => "Kitty"
    case _ => "Other"
  }

  def checkSamAge(pet: Animal): String = pet.name match {
    case "Sam" => s"Sam's sage is: ${pet.age}"
    case _ => s"${pet.name} is not Sam"
  }

  def checkAdult(pet: Animal): String = pet match {
    case x if pet.age > 10 => s"${pet.name} is ${pet.age} years old"
    case _ => s"${pet.name} is young"
  }

  val a: Dog = Dog("Sam", 11)
  val b: Dog = Dog("Daniel", 8)
  val c: Cat = Cat("Scratchy", 10)

  println(checkDogOrCat(c))
  println(checkDogOrCat(a))
  println(checkSamAge(a))
  println(checkSamAge(b))
  println(checkAdult(a))
  println(checkAdult(c))
}
