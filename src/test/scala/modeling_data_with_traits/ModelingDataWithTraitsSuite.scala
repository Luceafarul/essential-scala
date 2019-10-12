package modeling_data_with_traits

import modeling_data_with_traits.algebraic_data_types.{Calculation, Fail, Succeed}
import modeling_data_with_traits.sealed_traits._
import modeling_data_with_traits.traits._
import org.scalatest.{FunSuite, Matchers}

class ModelingDataWithTraitsSuite extends FunSuite with Matchers {
  test("Cat sound should be 'meow' and other Feline should be 'roar'") {
    val cat = Cat("white", "chips")
    val lion = Lion("gray", 7)
    val tiger = Tiger("black and yellow")
    val panther = Panther("black")

    cat.sound shouldBe "meow"
    lion.sound shouldBe "roar"
    tiger.sound shouldBe "roar"
    panther.sound shouldBe "roar"
  }

  test("Shape subtypes should be correct evaluate perimeter and area") {
    val customColor = CustomColor(3, 3, 3)
    val circle = Circle(5, customColor)
    val square = Square(7, customColor)
    val rectangle = Rectangle(5, 7, customColor)

    circle.perimeter shouldBe 2 * 5 * Math.PI
    circle.area shouldBe 5 * 5 * Math.PI

    square.perimeter shouldBe 4 * 7
    square.area shouldBe 7 * 7

    rectangle.perimeter shouldBe (5 + 7) * 2
    rectangle.area shouldBe 5 * 7
  }

  test("Draw object should return appropriate shapes describe") {
    val circle = Circle(5, CustomColor(3, 3, 3))
    val square = Square(7, Yellow)
    val rectangle = Rectangle(5, 7, Green)

    Draw(circle) shouldBe "A light circle with radius 5.0cm"
    Draw(square) shouldBe "A yellow square with size 7.0cm"
    Draw(rectangle) shouldBe "A green rectangle of width 5.0cm and height 7.0cm"
  }

  test("divide(3, 2) should be Finite(1.5)") {
    divide(3, 2) shouldBe Finite(1.5)
  }

  test("divide(2, 0) should be Infinite") {
    divide(2, 0) shouldBe Infinite
  }

  test("TrafficLight's action method should be appropriate action by color") {
    import modeling_data_with_traits.algebraic_data_types.{Green, Red, Yellow}

    val red = Red
    val yellow = Yellow
    val green = Green

    red.action shouldBe "stop"
    yellow.action shouldBe "ready"
    green.action shouldBe "go"
  }

  test("TrafficLight's next method should be appropriate next light") {
    import modeling_data_with_traits.algebraic_data_types.{Green, Red, Yellow}

    val red = Red
    val yellow = Yellow
    val green = Green

    red.next shouldBe Yellow
    yellow.next shouldBe Green
    green.next shouldBe Red
  }

  test("divide method from Calculation should return Succeed or Fail") {
    Calculation.divide(4, 2) shouldBe Succeed(2)

    Calculation.divide(7, 0) shouldBe Fail("division by zero")
  }

  test("Structural recursion using polymorphism dinner method should be return food") {
    val cat = Cat("white", "chips")
    val lion = Lion("gray", 7)
    val tiger = Tiger("black and yellow")
    val panther = Panther("black")

    cat.dinner shouldBe CatFood("chips")
    lion.dinner shouldBe Antelope
    tiger.dinner shouldBe TigerFood
    panther.dinner shouldBe Licorice
  }

  test("Structural recursion using pattern matching dinner method should be return food") {
    val cat = Cat("white", "chips")
    val lion = Lion("gray", 7)
    val tiger = Tiger("black and yellow")
    val panther = Panther("black")

    cat.dinners shouldBe CatFood("chips")
    lion.dinners shouldBe Antelope
    tiger.dinners shouldBe TigerFood
    panther.dinners shouldBe Licorice
  }
}