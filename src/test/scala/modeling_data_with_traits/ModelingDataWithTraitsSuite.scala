package modeling_data_with_traits

import modeling_data_with_traits.traits.{Cat, Circle, Lion, Panther, Rectangle, Square, Tiger}
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
    val circle = Circle(5)
    val square = Square(7)
    val rectangle = Rectangle(5, 7)

    circle.perimeter shouldBe 2 * 5 * Math.PI
    circle.area shouldBe 5 * 5 * Math.PI

    square.perimeter shouldBe 4 * 7
    square.area shouldBe 7 * 7

    rectangle.perimeter shouldBe (5 + 7) * 2
    rectangle.area shouldBe 5 * 7
  }
}