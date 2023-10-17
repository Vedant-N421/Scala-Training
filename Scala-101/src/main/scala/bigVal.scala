object bigVal extends App{
  def getBigVal(input1: Int, input2: Int): String = if (input1 == input2) "same" else if (input1 > input2) "first" else "second"

  println(getBigVal(78, 64))
  println(getBigVal(3, 3))
  println(getBigVal(90, 120))
}
