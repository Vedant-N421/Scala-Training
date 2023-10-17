object HOFs extends App{
  val pi = 3.14
  val areaCircle: Double => Double = radius => pi * radius * radius
  val circumCircle: Double => Double = radius => 2 * pi * radius

  val circleFunc: ((Double => Double), List[Double]) => List[Double] = (func, radii) => radii.map(func)
  val radii = List(5, 6, 9.45, 12.3)

  println(circleFunc(areaCircle, radii))
  println(circleFunc(circumCircle, radii))
}
