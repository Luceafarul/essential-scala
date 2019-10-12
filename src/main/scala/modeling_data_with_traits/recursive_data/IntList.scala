package modeling_data_with_traits.recursive_data

import scala.annotation.tailrec

sealed trait IntList {
  def length: Int = {
    @tailrec
    def loop(list: IntList, acc: Int = 0): Int = list match {
      case End => acc
      case Pair(_, tail) => loop(tail, acc + 1)
    }

    loop(this)
  }
}

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

object IntListOps {
  def sum(list: IntList): Int = {
    @tailrec
    def loop(list: IntList, acc: Int = 0): Int = list match {
      case End => acc
      case Pair(head, tail) => loop(tail, head + acc)
    }

    loop(list)
  }

  def product(list: IntList): Int = list match {
    case End => 1
    case Pair(head, tail) => head * product(tail)
  }

  def double(list: IntList): IntList = list match {
    case End => End
    case Pair(head, tail) => Pair(head * 2, double(tail))
  }
}
