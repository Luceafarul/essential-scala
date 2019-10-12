package modeling_data_with_traits.recursive_data

sealed trait Tree {
  def sum: Int

  def double: Tree
}

final case class Node(left: Tree, right: Tree) extends Tree {
  override def sum: Int = left.sum + right.sum

  override def double: Tree = Node(left.double, right.double)
}

final case class Leaf(value: Int) extends Tree {
  override def sum: Int = value

  override def double: Tree = Leaf(value * 2)
}

object TreeOps {
  def sum(tree: Tree): Int = tree match {
    case Leaf(value) => value
    case Node(left, right) => sum(left) + sum(right)
  }

  def double(tree: Tree): Tree = tree match {
    case Leaf(value) => Leaf(value * 2)
    case Node(left, right) => Node(double(left), double(right))
  }
}
