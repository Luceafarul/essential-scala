package collections.option

object OptionExercises {
  def addOptions(a: Option[Int], b: Option[Int]): Option[Int] = for {
    v1 <- a
    v2 <- b
  } yield v1 + v2

  def addOptionsMap(a: Option[Int], b: Option[Int]): Option[Int] =
    a.flatMap(v1 => b.map(v2 => v1 + v2))

  def addOptions(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = for {
    v1 <- a
    v2 <- b
    v3 <- c
  } yield v1 + v2 + v3

  def addOptionsMap(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] =
    a.flatMap(v1 => b.flatMap(v2 => c.map(v3 => v1 + v2 + v3)))

  def divide(a: Int, b: Int): Option[Int] =
    if (b == 0) None else Some(a / b)

  def divideOptions(a: Option[Int], b: Option[Int]): Option[Int] = for {
    v1 <- a
    v2 <- b
    res <- divide(v1, v2)
  } yield res

  def sumOptions(a: Option[Int], b: Option[Int]): Option[Int] = a.flatMap(v1 => b.map(v2 => v1 + v2))

  def minusOptions(a: Option[Int], b: Option[Int]): Option[Int] = a.flatMap(v1 => b.map(v2 => v1 - v2))

  def multipleOptions(a: Option[Int], b: Option[Int]): Option[Int] = a.flatMap(v1 => b.map(v2 => v1 * v2))

  def calculator(operand1: String, operator: String, operand2: String): Option[Int] = {
    val a = operand1.toIntOption
    val b = operand2.toIntOption
    operator match {
      case "+" => sumOptions(a, b)
      case "-" => minusOptions(a, b)
      case "*" => multipleOptions(a, b)
      case "/" => divideOptions(a, b)
      case _ => None
    }
  }

  def calculatorWithFor(operand1: String, operator: String, operand2: String): Option[Int] = for {
    a <- operand1.toIntOption
    b <- operand2.toIntOption
    res <- operator match {
      case "+" => Some(a + b)
      case "-" => Some(a - b)
      case "*" => Some(a * b)
      case "/" => divide(a, b)
      case _ => None
    }
  } yield res
}
