package collections.maps_and_sets

import org.scalatest.{FunSuite, Matchers}

class MapsAndSetsExercisesSpec extends FunSuite with Matchers {
  val people = Set("Alice", "Bob", "Charlie", "Derek", "Edith", "Fred")
  val ages = Map("Alice" -> 20, "Bob" -> 30, "Charlie" -> 50, "Derek" -> 40, "Edith" -> 10, "Fred" -> 60)
  val favoriteColors = Map("Bob" -> "green", "Derek" -> "magenta", "Fred" -> "yellow")
  val favoriteLolcats = Map("Alice" -> "Long Cat", "Charlie" -> "Ceiling Cat", "Edith" -> "Cloud Cat")

  test("favoriteColors should return favorite color by person name") {
    MapsAndSetsExercises.favoriteColors("Bob", favoriteColors) shouldBe "green"
  }

  test("favoriteColors should return beige if person not found") {
    MapsAndSetsExercises.favoriteColors("Marie", favoriteColors) shouldBe "beige"
  }

  test("printColors should return string of everyone's with favorite colors") {
    MapsAndSetsExercises.printColors(people, favoriteColors) shouldBe
      """|Alice's favorite color is beige
         |Charlie's favorite color is beige
         |Bob's favorite color is green
         |Edith's favorite color is beige
         |Derek's favorite color is magenta
         |Fred's favorite color is yellow""".stripMargin
  }

  test("colorOfOldestPerson should return oldest person's favorite color") {
    MapsAndSetsExercises.colorOfOldestPersonColors(ages, favoriteColors) shouldBe "yellow"
  }

  test("union of two set should return their union (same elements in both sets)") {
    def set1 = Set(1, 2, 3, 4, 73, 21, 7)
    def set2 = Set(7, 13, 21, 73, 0, 1)
    MapsAndSetsExercises.union(set1, set2) shouldBe Set(1, 7, 21, 73)
  }

  test("union of two maps: Map[A, Int] should return union of key with sum of values for equals key") {
    def map1 = Map("a" -> 1, "b" -> 3, "c" -> 5, "d" -> 7)
    def map2 = Map("c" -> 1, "d" -> 14, "y" -> 73)
    MapsAndSetsExercises.union(map1, map2) shouldBe Map("c" -> 6, "d" -> 21)
  }

  test("generic union of two maps: Map[A, B] should return union of key with sum of values for equals key") {
    def map1 = Map('a' -> "apple", 'b' -> "bar", 'c' -> "container", 'd' -> "docker")
    def map2 = Map('c' -> "control", 'd' -> "disco", 'y' -> "yasuo")
    MapsAndSetsExercises.union(map1, map2)((s1, s2) => s"$s1 $s2") shouldBe Map('c' -> "container control", 'd' -> "docker disco")
  }
}
