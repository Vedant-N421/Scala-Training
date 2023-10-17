object FilmRatings extends App{
  def get_ratings(age: Int): List[String]= {
    val film_ratings: List[String] = List("U", "PG", "12A", "15", "18")
    if (age >= 18)
      film_ratings
    else if (age >= 15)
      film_ratings.slice(0, 4)
    else if (age >= 12)
      film_ratings.slice(0, 3)
    else if (age >= 8)
      film_ratings.slice(0, 2)
    else if (age >= 4)
      film_ratings.slice(0, 1)
    else
      List("")
  }
  println(get_ratings(2))
  println(get_ratings(4))
  println(get_ratings(9))
  println(get_ratings(12))
  println(get_ratings(15))
  println(get_ratings(20))
}
