package sequencing_computations.generics

trait Sum[+A, +B] {
  def fold[C](left: A => C, right: B => C): C = this match {
    case Left(value) => left(value)
    case Right(value) => right(value)
  }

  def map[C](f: B => C): Sum[A, C] = this match {
    case Left(value) => Left(value)
    case Right(value) => Right(f(value))
  }

  def flatMap[C, AA >: A](f: B => Sum[AA, C]): Sum[AA, C] = this match {
    case Left(value) => Left(value)
    case Right(value) => f(value)
  }
}

final case class Left[A](value: A) extends Sum[A, Nothing]

final case class Right[B](value: B) extends Sum[Nothing, B]
