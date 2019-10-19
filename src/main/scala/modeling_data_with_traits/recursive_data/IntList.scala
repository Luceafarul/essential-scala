package modeling_data_with_traits.recursive_data

sealed trait IntList {
  def length: Int = this.fold[Int](0, (_, t) => t + 1)

  def sum: Int = this.fold[Int](0, _ + _)

  def product: Int = this.fold[Int](1, _ * _)

  def double: IntList = this.fold(End, (h, t) => Pair(h * 2, t))

  def fold[A](end: A, f: (Int, A) => A): A = this match {
    case End => end
    case Pair(h, t) => f(h, t.fold(end, f))
  }
}

final case class Pair(head: Int, tail: IntList) extends IntList

case object End extends IntList
