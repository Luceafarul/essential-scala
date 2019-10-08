package modeling_data_with_traits.traits

trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

trait Rectangular extends Shape {
  def width: Double

  def height: Double

  override def sides: Int = 4

  override def perimeter: Double = (width + height) * 2

  override def area: Double = width * height
}

case class Circle(radius: Double) extends Shape {
  override def sides: Int = 1

  override def perimeter: Double = 2 * Math.PI * radius

  override def area: Double = Math.PI * Math.pow(radius, 2)
}

case class Rectangle(width: Double, height: Double) extends Rectangular

case class Square(size: Double) extends Rectangular {
  override def width: Double = size

  override def height: Double = size
}