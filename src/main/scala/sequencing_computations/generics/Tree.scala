package sequencing_computations.generics

trait Tree[A] {
  def fold[B](end: B, f: (A, B) => B): B = this match {
    case Leaf(value) => f(value, end)
    case Node(left, right) => left.fold(right.fold(end, f), f)
  }

  override def toString: String = this.fold[String]("", (a, b) => s"$a $b".trim)
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]
