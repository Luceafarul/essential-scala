package sequencing_computations

import org.scalatest.{FunSuite, Matchers}
import sequencing_computations.generics.{Empty, Full, Maybe}

class MaybeSuite extends FunSuite with Matchers {
  test("Maybe should be Full or Empty type with corresponding value") {
    val m1: Maybe[Int] = Full(73)
    val m2: Maybe[Int] = Empty

    m1 shouldBe Full(73)
    m2 shouldBe Empty
  }

  test("map Full should be return Full with applied value") {
    val m1: Maybe[Int] = Full(73)

    m1.map(_ * 3) shouldBe Full(219)
  }

  test("map Empty should be return Empty") {
    val m1: Maybe[String] = Empty

    m1.map(_.toUpperCase) shouldBe Empty
  }
}
