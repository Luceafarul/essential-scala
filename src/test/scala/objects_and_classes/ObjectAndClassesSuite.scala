package objects_and_classes

import org.scalatest.{FunSuite, Matchers}

class ObjectAndClassesSuite extends FunSuite with Matchers {
  test("willServe should return true if the cat's favorite food is chips") {
    val catOne = new Cat("Oswald", "Black", "Milk")
    val catTwo = new Cat("Henderson", "Ginger", "Chips")

    ChipShop.willServe(catOne) shouldBe false
    ChipShop.willServe(catTwo) shouldBe true
  }

  test("validate Film and Director class implementation") {
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)
    val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)

    eastwood.yearOfBirth shouldBe 1930
    dieHard.director.name shouldBe "John McTiernan"
    invictus.isDirectedBy(nolan) shouldBe false
  }

  test("copy method of Film without parameters should return a copy of instance") {
    val nolan = new Director("Christopher", "Nolan", 1970)
    val inception = new Film("Inception", 2010, 8.8, nolan)

    inception.copy().copy().copy() equals inception
  }

  test("copy method of Film with changed parameters should return updated copy") {
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)

    val highPlainsDrifterCopy = highPlainsDrifter.copy(name = "L'homme des hautes plaines")

    highPlainsDrifterCopy.name shouldBe "L'homme des hautes plaines"
    highPlainsDrifterCopy.yearOfRelease shouldBe highPlainsDrifter.yearOfRelease
    highPlainsDrifterCopy.imdbRating shouldBe highPlainsDrifter.imdbRating
    highPlainsDrifterCopy.director shouldBe highPlainsDrifter.director

    val mcTiernan = new Director("John", "McTiernan", 1951)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    val thomasCrownAffairCopy = thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director("Norman", "Jewison", 1926))

    thomasCrownAffairCopy.name shouldBe thomasCrownAffair.name
    thomasCrownAffairCopy.yearOfRelease shouldBe 1968
    thomasCrownAffairCopy.imdbRating shouldBe thomasCrownAffair.imdbRating
    thomasCrownAffairCopy.director equals new Director("Norman", "Jewison", 1926)
  }

  test("Counter without parameter should start from 1") {
    val counter = new Counter

    counter.count shouldBe 1
  }

  test("inc and dec method of Counter should be increment and decrement count respectively") {
    val counter = new Counter(10)

    counter.inc.dec.inc.inc.count shouldBe 12
  }

  test("adjust method should be increment Counter by Adder amount") {
    val adder = new Adder(10)
    val counter = new Counter

    counter.adjust(adder).count shouldBe 11
  }
}
