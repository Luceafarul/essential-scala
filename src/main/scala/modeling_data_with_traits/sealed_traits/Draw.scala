package modeling_data_with_traits.sealed_traits

import modeling_data_with_traits.traits.{Circle, Rectangle, Shape, Square}

object Draw {
  def apply(shape: Shape): String = shape match {
    case Square(size, color) => s"A ${Draw(color)} square with size ${size}cm"
    case Circle(radius, color) => s"A ${Draw(color)} circle with radius ${radius}cm"
    case Rectangle(width, height, color) => s"A ${Draw(color)} rectangle of width ${width}cm and height ${height}cm"
  }

  def apply(color: Color): String = color match {
    case Red => "red"
    case Green => "green"
    case Blue => "green"
    case Yellow => "yellow"
    case custom: CustomColor => if (custom.isLight) "light" else "dark"
  }
}
