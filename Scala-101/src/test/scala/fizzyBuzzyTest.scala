import fizzyBuzzy.fizzBuzz
import org.scalatest.flatspec._

class fizzyBuzzyTest extends AnyFlatSpec{
    "Breaking Test" should "Break if there is nothing there!" in {
        assert(fizzBuzz(15) == "FizzBuzz")
    }

    "Testing three" should "return fizz" in {
        assert(fizzBuzz(3) == "Fizz")
    }

    "Testing five" should "return buzz" in {
        assert(fizzBuzz(5) == "Buzz")
    }

    "Testing zero" should "return nothing" in {
        assert(fizzBuzz(0) == "")
    }

    "Testing 14" should "return nothing" in {
        assert(fizzBuzz(14) == "")
    }

    "Testing 30" should "return fizzbuzz" in {
        assert(fizzBuzz(30) == "FizzBuzz")
    }

    "Testing 65" should "return buzz" in {
        assert(fizzBuzz(65) == "Buzz")
    }

    "Testing 9" should "return fizz" in {
        assert(fizzBuzz(9) == "Fizz")
    }
}
