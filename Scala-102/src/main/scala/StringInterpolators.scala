object StringInterpolators extends App{
  val kev: String = "Kevin"
  val amy: String = "Amy"
  println(s"$kev is older than $amy")

  var kev_age: Int = 50
  var amy_age: Int = 40

  println(s"$kev is ${kev_age - amy_age} years older than $amy")

  val kev2_age: Double = 30.5
  val amy2_age: Double = 20.5

  println(f"$kev is ${kev2_age - amy2_age}%.1f years older than $amy")

  println(raw"“\n\n\n\n\n\n\n\nsameline\n\n”")

  case class Person(name: String, age: Int, favourite_hobby : String, favourite_colour : String, mothers_maiden_name: String, street_growing_up: String, last_three_digits: Int)

  val victim: Person = Person("Tom", 34, favourite_hobby = "Chess", favourite_colour = "Red", mothers_maiden_name = "Mary", street_growing_up = "Bleak Lane", last_three_digits = 390)

  println(s"${victim.name} is about to meet ${victim.mothers_maiden_name} to get absolutely scammed.")
  println(f"The perpetrator knows what his card looks like, including the last three digits: ${victim.last_three_digits}")
  println(raw"He is about be blasted while playing ${victim.favourite_hobby} in his ${victim.favourite_colour} t-shirt.")
}
