package sequencing_computations

import org.scalatest.{FunSuite, Matchers}
import sequencing_computations.generics.{Cons, Failure, Nil, Success}

class SequencingComputationSuite extends FunSuite with Matchers {
  test("length of empty LinkedList should return 0") {
    val list = Nil()

    list.length shouldBe 0
  }

  test("length of non empty LinkedList should return appropriate size") {
    val list = Cons(1, Cons(2, Cons(3, Nil())))

    list.length shouldBe 3
  }

  test("contains should return true if element exist in LinkedList") {
    val list = Cons(1, Cons(2, Cons(3, Nil())))

    list.contains(3) shouldBe true
    list.contains(1) shouldBe true
  }

  test("contains should return false if element does not exist in LinkedList") {
    val list = Cons(1, Cons(2, Cons(3, Nil())))
    val empty = Nil[Int]()

    list.contains(5) shouldBe false
    empty.contains(4) shouldBe false
  }

  test("apply should return nth element in LinkedList") {
    val list = Cons(1, Cons(2, Cons(3, Nil())))

    list(0) shouldBe Success(1)
    list(2) shouldBe Success(3)
  }

  test("apply should thrown exception if out of the bound") {
    val list = Cons(1, Cons(2, Cons(3, Nil())))
    val empty = Nil[Int]()

    list(5) shouldBe Failure("Index out of bound")
    empty(0) shouldBe Failure("Index out of bound")
  }
}
