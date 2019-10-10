package modeling_data_with_traits.sealed_traits

import modeling_data_with_traits.traits.{Circle, Rectangle, Shape, Square}

object Draw {
  def apply(shape: Shape): String = shape match {
    case Square(size) => s"A square with size ${size}cm"
    case Circle(radius) => s"A circle with radius ${radius}cm"
    case Rectangle(width, height) => s"A rectangle of width ${width}cm and height ${height}cm"
  }
}
