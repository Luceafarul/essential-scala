package collections.maps_and_sets

object MapsAndSetsExercises {
  def favoriteColors(name: String, colors: Map[String, String]): String = colors.getOrElse(name, "beige")

  def printColors(people: Set[String], favoriteColors: Map[String, String]): String = people.map { name =>
    val color = favoriteColors.getOrElse(name, "beige")
    s"$name's favorite color is $color"
  }.mkString(sep = "\n")

  def colorOfOldestPersonColors(ages: Map[String, Int], favoriteColors: Map[String, String]): String = {
    val oldestPerson = ages.foldLeft(ages.head) { (p1, p2) => if (p1._2 > p2._2) p1 else p2 }
    favoriteColors.getOrElse(oldestPerson._1, "beige")
  }

  def union[A](s1: Set[A], s2: Set[A]): Set[A] = for {
    e1 <- s1
    e2 <- s2
    if e1 == e2
  } yield e1

  def union[A](m1: Map[A, Int], m2: Map[A, Int]): Map[A, Int] = for {
    (key1, value1) <- m1
    (key2, value2) <- m2
    if key1 == key2
  } yield key1 -> (value1 + value2)

  def union[A, B](m1: Map[A, B], m2: Map[A, B])(sum: (B, B) => B): Map[A, B] = for {
    (key1, value1) <- m1
    (key2, value2) <- m2
    if key1 == key2
  } yield key1 -> sum(value1, value2)
}
