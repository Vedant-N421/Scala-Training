object ExamScores extends App{
  val multiply12: Option[Int] => Int = {
    case Some(num) => num * 12
    case None => 12
  }

  println(multiply12(Some(12)))
  println(multiply12(None))

  val results: Seq[Option[String]] = Seq(None, Some("A"), Some("B"), Some("C"), None, Some("F"))
  val resultsToGrade: Seq[Option[String]] => Seq[String] = res => (res.map {case None => "F" case Some(x) => x})

  println(results)
  println(resultsToGrade(results))

}
