object Either extends App{
  def userExists(username: String, password: String): Boolean = {
    (username, password) match {
      case ("Boris Johnson", "pword123") => true
      case ("Barack Obama", "merica") => true
      case _ => false
    }
  }
  val logIn: (String, String) => Either[String, Boolean] = (username, password) => userExists(username, password) match {
    case true => Right(true)
    case false => Left("UserNotFoundError")
  }

  println(logIn("Vedant", "ItsMe"))
  println(logIn("Barack Obama", "merica"))
}
