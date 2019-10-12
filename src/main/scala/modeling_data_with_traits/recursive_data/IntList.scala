package modeling_data_with_traits.recursive_data

sealed trait IntList

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

object IntListOps {
  def sum(list: IntList): Int = list match {
    case End => 0
    case Pair(head, tail) => head + sum(tail)
  }
}
