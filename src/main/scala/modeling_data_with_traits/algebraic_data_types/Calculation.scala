package modeling_data_with_traits.algebraic_data_types

sealed trait Calculation

object Calculation {
  def divide(a: Int, b: Int): Calculation = if (b != 0) Succeed(a / b) else Fail("division by zero")
}

final case class Succeed(result: Int) extends Calculation

final case class Fail(message: String) extends Calculation
