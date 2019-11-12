package collections.option

import org.scalatest.{FunSuite, Matchers}

class OptionExercisesSpec extends FunSuite with Matchers {
  test("addOptions should return sum of two values") {
    val optionOne = Some(19)
    val optionTwo = Some(2)

    OptionExercises.addOptions(optionOne, optionTwo) shouldBe Some(21)
    OptionExercises.addOptionsMap(optionOne, optionTwo) shouldBe Some(21)
  }

  test("addOptions should return None if one of two Options is None") {
    val optionOne = Some(19)
    val optionTwo = None

    OptionExercises.addOptions(optionOne, optionTwo) shouldBe None
    OptionExercises.addOptionsMap(optionOne, optionTwo) shouldBe None
  }

  test("addOptions should return sum of three values") {
    val optionOne = Some(19)
    val optionTwo = Some(2)
    val optionThree = Some(80)

    OptionExercises.addOptions(optionOne, optionTwo, optionThree) shouldBe Some(101)
    OptionExercises.addOptionsMap(optionOne, optionTwo, optionThree) shouldBe Some(101)
  }

  test("addOptions should return None if one of three Options is None") {
    val optionOne = Some(19)
    val optionTwo = None
    val optionThree = Some(81)

    OptionExercises.addOptions(optionOne, optionTwo, optionThree) shouldBe None
    OptionExercises.addOptionsMap(optionOne, optionTwo, optionThree) shouldBe None
  }

  test("divide should return Some(division) when denominator not 0") {
    OptionExercises.divide(8, 2) shouldBe Some(4)
  }

  test("divide should return None if denominator is 0") {
    OptionExercises.divide(8, 0) shouldBe None
  }

  test("divideOption should return Some(division) when denominator not 0") {
    OptionExercises.divideOptions(Some(8), Some(2)) shouldBe Some(4)
  }

  test("divideOption method should return None if denominator is 0") {
    OptionExercises.divideOptions(Some(8), None) shouldBe None
  }

  test("calculator correctly perform supported operation (+, -, *, /)") {
    OptionExercises.calculator("30", "+", "43") shouldBe Some(73)
    OptionExercises.calculator("57", "-", "27") shouldBe Some(30)
    OptionExercises.calculator("73", "*", "3") shouldBe Some(219)
    OptionExercises.calculator("140", "/", "14") shouldBe Some(10)
  }

  test("calculator return None if one of the operands None for supported operation (+, -, *, /)") {
    OptionExercises.calculator("30", "+", "a") shouldBe None
    OptionExercises.calculator("57", "-", "2o7") shouldBe None
    OptionExercises.calculator("73", "*", "3I") shouldBe None
    OptionExercises.calculator("149", "/", "V") shouldBe None
  }

  test("calculator return None for unsupported operation (not in (+, -, *, /))") {
    OptionExercises.calculator("30", "%", "20") shouldBe None
  }

  test("calculator return None division by zero") {
    OptionExercises.calculator("149", "/", "0") shouldBe None
  }
}
