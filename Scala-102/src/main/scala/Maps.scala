object Maps extends App{
  val toUp: String => String = str => str.map(x => x.toUpper)
  val str = "macbooks"
  println(s"${toUp(str)} ARE THE BEST!")

  val charToNum: List[String] => Int = input => input.map(x => x.toInt * 2).sum
  val charArr: List[String] = List("1", "2", "3")
  println(s"${charToNum(charArr)}")
}
