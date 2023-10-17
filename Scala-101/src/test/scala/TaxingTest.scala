import Taxing.{calculateTax, funcCalculateTax}
import org.scalatest.flatspec.AnyFlatSpec

class TaxingTest extends AnyFlatSpec{
  "Breaking Test" should "Break if there is nothing there!" in {
    assert(calculateTax(30000) == 30000*0.15)
  }

  "110,000" should "return 40% of the value" in {
    assert(calculateTax(110000) == 110000 * 0.4)
  }

  "50,000" should "return 15% of the value" in {
    assert(calculateTax(50000) == 50000 * 0.15)
  }

  "11,000" should "return 15% of the value" in {
    assert(calculateTax(11000) == 11000 * 0.15)
  }

  "9000" should "return 10% of the value" in {
    assert(calculateTax(9000) == 9000 * 0.1)
  }

  "8000" should "return 10% of the value" in {
    assert(funcCalculateTax(8000) == 8000 * 0.1)
  }
}
