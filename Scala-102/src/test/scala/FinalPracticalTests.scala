import FinalPractical._
import org.scalatest.flatspec._

class FinalPracticalTests extends AnyFlatSpec {
  "Empty list" should "return £0.00" in {
    assert(getBill(List(), 1) == 0.00)
  }

  "Getting a cola without loyalty" should "return £0.50" in {
    assert(getBill(List(Cola()), 1) == 0.50)
  }

  "Getting two coffees and a cola" should "return £2.50" in {
    assert(getBill(List(Coffee(), Coffee(), Cola()), 1) == 2.50)
  }

  "Getting a cheese sandwich should add service bill" should "return £2.20" in {
    assert(getBill(List(CheeseSandwich()), 1) == 2.20)
  }

}
