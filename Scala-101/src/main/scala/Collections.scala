object Collections extends App{
  val names: Seq[String] = Seq("Vedant", "Omiros", "Aashvin", "Kuldeep")
  val colors: Map[Int, String] = Map(1 -> "red", 2 -> "yellow", 3 -> "blue", 4 -> "refrigerator", 2 -> "purple")
  println(s"You can actually have duplicate keys, see this: ${colors(2)}")

  val testSeq: Seq[Int] = Seq(1, 2, 3, 4, 6, 10)
  def funcAddOne(input: Seq[Int]): Seq[Int] = input.map(x => x + 1)
  println(s"Adding 1 to every element in ${testSeq} gives: ${funcAddOne(testSeq)}")
  def funcRemoveEven(input: Seq[Int]): Seq[Int] = input.filter(x => x % 2 != 0)
  println(s"Removing the even numbers gives: ${funcRemoveEven(testSeq)}")
  def containsT(input: Seq[String]): Boolean = input.exists(x => x.contains("t"))
  println(s"Checking if 't' exists in ${names} gives: ${containsT(names)}")
}
