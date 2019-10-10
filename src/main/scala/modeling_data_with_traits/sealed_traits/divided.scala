package modeling_data_with_traits.sealed_traits

object divide {
  def apply(a: Int, b: Int): DivisionResult = if (b != 0) Finite(a / b.toDouble) else Infinite
}

sealed trait DivisionResult

final case class Finite(result: Double) extends DivisionResult

case object Infinite extends DivisionResult
