package sequencing_computations

import org.scalatest.{FunSuite, Matchers}
import sequencing_computations.generics.Pair

class PairSuite extends FunSuite with Matchers {
  test("pair should contains two values of different types") {
    val pair: Pair[Int, String] = Pair(73, "Hello")

    pair.one shouldBe 73
    pair.two shouldBe "Hello"
  }
}
