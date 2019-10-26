package sequencing_computations

import org.scalatest.{FunSuite, Matchers}
import sequencing_computations.generics.{Sum, Right, Left}

class SumSuite extends FunSuite with Matchers {
  test("Sum should be Left or Right type with corresponding value") {
    val s1: Sum[Int, String] = Left(73)
    val s2: Sum[Int, String] = Right("Scala")

    value(s1) shouldBe 73
    value(s2) shouldBe "Scala"
  }

  test("Apply map to Right should return modified by function value") {
    val s1: Sum[Int, String] = Right("Scala")

    s1.map(_.length) shouldBe Right(5)
  }

  test("Apply map to Left should be not applied function to value") {
    val s1: Sum[String, String] = Left("Failure computation!")

    s1.map(_.toUpperCase) shouldBe Left("Failure computation!")
  }

  test("Apply flatMap to Right should return modified by function value") {
    val s1: Sum[Int, String] = Right("Scala")

    s1.flatMap(value => Right(value.toUpperCase)) shouldBe Right("SCALA")
  }

  test("Apply flatMap to Left should be not applied function to value") {
    val s1: Sum[String, String] = Left("Failure computation!")

    s1.flatMap(error => Left[String](s"Error: $error")) shouldBe Left("Failure computation!")
  }

  private def value[A, B](sum: Sum[A, B]): Any = sum match {
    case Left(value) => value
    case Right(value) => value
  }
}
