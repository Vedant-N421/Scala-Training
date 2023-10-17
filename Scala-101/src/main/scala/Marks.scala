object Marks extends App{
  def gradeCheck(mark: Int): String = {
    if (mark >= 90)
      "A"
    else if (mark >= 80)
      "B"
    else if (mark >= 70)
      "C"
    else if (mark >= 60)
      "D"
    else if (mark >= 50)
      "E"
    else if (mark >= 40)
      "F"
    else
      "U"
  }

  println(gradeCheck(100))
  println(gradeCheck(10))
  println(gradeCheck(45))
  println(gradeCheck(95))
}
