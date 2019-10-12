package modeling_data_with_traits.algebraic_data_types

sealed trait Calculation

object Calculation {
  def divide(a: Int, b: Int): Calculation = if (b != 0) Success(a / b) else Failure("division by zero")
}

final case class Success(result: Int) extends Calculation

final case class Failure(message: String) extends Calculation

object Calculator {
  def +(calculation: Calculation, i: Int): Calculation = calculation match {
    case Success(value) => Success(value + i)
    case Failure(message) => Failure(message)
  }

  def -(calculation: Calculation, i: Int): Calculation = calculation match {
    case Success(value) => Success(value - i)
    case Failure(message) => Failure(message)
  }

  def /(calculation: Calculation, i: Int): Calculation = calculation match {
    case _ if i == 0 => Failure("division by zero")
    case Success(value) => Success(value / i)
    case Failure(message) => Failure(message)
  }
}
