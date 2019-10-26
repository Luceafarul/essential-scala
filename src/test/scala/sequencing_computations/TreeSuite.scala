package sequencing_computations

import org.scalatest.{FunSuite, Matchers}
import sequencing_computations.generics.{Leaf, Node, Tree}

class TreeSuite extends FunSuite with Matchers {
  test("toString should use concatenate Leaf value of Tree") {
    val tree: Tree[String] =
      Node(Node(Leaf("To"), Leaf("iterate")),
        Node(Node(Leaf("is"), Leaf("human,")),
          Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

    tree.toString shouldBe "To iterate is human, to recurse divine"
  }
}
