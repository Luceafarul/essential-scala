package modeling_data_with_traits.extended_examples

sealed trait Expression {
  def eval1: Double = this match {
    case Addition(left, right) => left.eval1 + right.eval1
    case Subtraction(left, right) => left.eval1 - right.eval1
    case Division(left, right) => left.eval1 / right.eval1
    case SquareRoot(value) => math.sqrt(value.eval1)
    case Number(value) => value
  }

  def eval: Calculation = this match {
    case Number(value) => Success(value)
    case Addition(left, right) => left.eval match {
      case Success(leftValue) => right.eval match {
        case Success(rightValue) => Success(leftValue + rightValue)
        case Failure(reason) => Failure(reason)
      }
      case Failure(reason) => Failure(reason)
    }
    case Subtraction(left, right) => left.eval match {
      case Success(leftValue) => right.eval match {
        case Success(rightValue) => Success(leftValue - rightValue)
        case Failure(reason) => Failure(reason)
      }
      case Failure(reason) => Failure(reason)
    }
    case Division(left, right) => left.eval match {
      case Success(leftValue) => right.eval match {
        case Success(rightValue) =>
          if (rightValue == 0) Failure("Division by zero")
          else Success(leftValue / rightValue)
        case Failure(value) => Failure(value)
      }
      case Failure(reason) => Failure(reason)
    }
    case SquareRoot(value) => value.eval match {
      case Success(value) =>
        if (value < 0) Failure(s"Square root of negative number: $value")
        else Success(math.sqrt(value))
      case Failure(value) => Failure(value)
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression

final case class Subtraction(left: Expression, right: Expression) extends Expression

final case class Number(value: Double) extends Expression

final case class Division(left: Expression, right: Expression) extends Expression

final case class SquareRoot(value: Expression) extends Expression


sealed trait Calculation

final case class Success(value: Double) extends Calculation

final case class Failure(reason: String) extends Calculation
