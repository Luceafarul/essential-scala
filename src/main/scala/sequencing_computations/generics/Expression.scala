package sequencing_computations.generics

sealed trait Expression {
  def eval: Sum[String, Double] = this match {
    case Number(value) => Right(value)
    case Addition(left, right) => left.eval.flatMap { leftRes =>
      right.eval.map { rightRes => leftRes + rightRes }
    }
    case Subtraction(left, right) => left.eval.flatMap { leftRes =>
      right.eval.map { rightRes => leftRes - rightRes }
    }
    case Division(left, right) => right.eval.flatMap { rightRes =>
      if (rightRes == 0) Left("Division by zero")
      else left.eval.map { _ / rightRes }
    }
    case SquareRoot(value) => value.eval.flatMap { res =>
      if (res < 0) Left(s"Square root of negative number: $res") else Right(math.sqrt(res))
    }
  }
}

final case class Subtraction(left: Expression, right: Expression) extends Expression

final case class Addition(left: Expression, right: Expression) extends Expression

final case class Division(left: Expression, right: Expression) extends Expression

final case class SquareRoot(value: Expression) extends Expression

final case class Number(value: Double) extends Expression


sealed trait Calculation

final case class Success(value: Double) extends Calculation

final case class Failure(reason: String) extends Calculation

