package sequencing_computations

import org.scalatest.{FunSuite, Matchers}
import sequencing_computations.generics.{Addition, Division, Left, Number, Right, SquareRoot, Subtraction}

class ExpressionSuite extends FunSuite with Matchers {
  test("Expression Number should eval to Right number") {
    val number = Number(73.7)

    number.eval shouldBe Right(73.7)
  }

  test("Expression Addition should eval sum of expression") {
    val sum = Addition(Number(7.2), Addition(Number(2.8), Number(3)))

    sum.eval shouldBe Right(13.0)
  }

  test("Expression Subtraction should eval subtract of expression") {
    val subtract1 = Subtraction(Number(7.2), Subtraction(Number(3.2), Number(3)))
    val subtract2 = Subtraction(Number(7.5), Addition(Number(3.5), Number(7)))

    subtract1.eval shouldBe Right(7.0)
    subtract2.eval shouldBe Right(-3.0)
  }

  test("Expression Division should eval division of expression") {
    val div = Division(Number(21), Addition(Number(3), Number(3)))

    div.eval shouldBe Right(3.5)
  }

  test("Division by zero should failure eval of expression") {
    val div = Division(Number(21), Addition(Number(0), Number(0)))

    div.eval shouldBe Left("Division by zero")
  }

  test("Expression SquareRoot should eval sqrt of expression") {
    val sqrt = SquareRoot(Subtraction(Number(100), Number(51)))

    sqrt.eval shouldBe Right(7.0)
  }

  test("SquareRoot of -1 should eval failure of expression") {
    val sqrt = SquareRoot(Subtraction(Number(0), Number(1)))

    sqrt.eval shouldBe Left("Square root of negative number: -1.0")
  }
}
