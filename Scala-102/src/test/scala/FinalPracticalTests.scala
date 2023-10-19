import FinalPractical._
import org.scalatest.flatspec._

class FinalPracticalTests extends AnyFlatSpec{
  val ls: List[MenuItem] = List(Cola())
  "Empty list" should "return £0.00" in {
    assert(getBill(ls, 3) == 0.00)
  }
}
