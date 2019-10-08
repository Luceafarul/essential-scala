package objects_and_classes

import org.scalatest.{FunSuite, Matchers}

class ObjectAndClassesSuite extends FunSuite with Matchers {
  test("willServe should return true if the cat's favorite food is chips") {
    val catOne = Cat("Oswald", "Black", "Milk")
    val catTwo = Cat("Henderson", "Ginger", "Chips")

    ChipShop.willServe(catOne) shouldBe false
    ChipShop.willServe(catTwo) shouldBe true
  }

  test("validate Film and Director class implementation") {
    val eastwood = Director("Clint", "Eastwood", 1930)
    val mcTiernan = Director("John", "McTiernan", 1951)
    val nolan = Director("Christopher", "Nolan", 1970)
    val invictus = Film("Invictus", 2009, 7.4, eastwood)
    val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)

    eastwood.yearOfBirth shouldBe 1930
    dieHard.director.name shouldBe "John McTiernan"
    invictus.isDirectedBy(nolan) shouldBe false
  }

  test("copy method of Film without parameters should return a copy of instance") {
    val nolan = Director("Christopher", "Nolan", 1970)
    val inception = Film("Inception", 2010, 8.8, nolan)

    inception.copy().copy().copy() equals inception
  }

  test("copy method of Film with changed parameters should return updated copy") {
    val eastwood = Director("Clint", "Eastwood", 1930)
    val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)

    val highPlainsDrifterCopy = highPlainsDrifter.copy(name = "L'homme des hautes plaines")

    highPlainsDrifterCopy.name shouldBe "L'homme des hautes plaines"
    highPlainsDrifterCopy.yearOfRelease shouldBe highPlainsDrifter.yearOfRelease
    highPlainsDrifterCopy.imdbRating shouldBe highPlainsDrifter.imdbRating
    highPlainsDrifterCopy.director shouldBe highPlainsDrifter.director

    val mcTiernan = Director("John", "McTiernan", 1951)
    val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    val thomasCrownAffairCopy = thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director("Norman", "Jewison", 1926))

    thomasCrownAffairCopy.name shouldBe thomasCrownAffair.name
    thomasCrownAffairCopy.yearOfRelease shouldBe 1968
    thomasCrownAffairCopy.imdbRating shouldBe thomasCrownAffair.imdbRating
    thomasCrownAffairCopy.director equals Director("Norman", "Jewison", 1926)
  }

  test("older director should return oldest of two directors") {
    val eastwood = Director("Clint", "Eastwood", 1930)
    val mcTiernan = Director("John", "McTiernan", 1951)

    Director.older(eastwood, mcTiernan) shouldBe eastwood
  }

  test("highestRating should return highest imdb rating of two films") {
    val nolan = Director("Christopher", "Nolan", 1970)
    val inception = Film("Inception", 2010, 8.8, nolan)

    val mcTiernan = Director("John", "McTiernan", 1951)
    val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)

    Film.highestRating(inception, dieHard) shouldBe inception
  }

  test("oldestDirectorAtTheTime should return director of two films who was oldest the time respective time of filming") {
    val nolan = Director("Christopher", "Nolan", 1970)
    val inception = Film("Inception", 2010, 8.8, nolan)

    val mcTiernan = Director("John", "McTiernan", 1951)
    val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)

    Film.oldestDirectorAtTheTime(inception, dieHard) shouldBe nolan
  }

  test("Counter without parameter should start from 1") {
    val counter = Counter()

    counter.count shouldBe 0
  }

  test("inc and dec method of Counter should be increment and decrement count respectively") {
    val counter = Counter(10)

    counter.inc.dec.inc.inc.count shouldBe 12
  }

  test("adjust method should be increment Counter by Adder amount") {
    val adder = new Adder(10)
    val counter = Counter()

    counter.adjust(adder).count shouldBe 10
  }

  test("Person should be created via apply method") {
    val person = Person("Han Solo")

    person.firstName shouldBe "Han"
    person.lastName shouldBe "Solo"
  }
}
