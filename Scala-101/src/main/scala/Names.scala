object Names extends App{
  def nameLength(firstName: String, surname: String): Int = {
    if (firstName.length() == surname.length()) 0 else firstName.length() max surname.length()
  }

  println(nameLength("Arnold", "Schwarzenegger"))
  println(nameLength("Bruce", "Lee"))
  println(nameLength("Ethan", "Hawke"))
}
