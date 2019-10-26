package sequencing_computations.generics

trait Maybe[+A] {
  def fold[B](init: B, f: (A) => B): B = this match {
    case Empty => init
    case Full(value) => f(value)
  }

  def map[B](f: A => B): Maybe[B] = flatMap(value => Full(f(value)))

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = this match {
    case Empty => Empty
    case Full(value) => f(value)
  }
}

final case class Full[A](value: A) extends Maybe[A]

case object Empty extends Maybe[Nothing]
