package modeling_data_with_traits.sealed_traits

sealed trait Color {
  def red: Int

  def green: Int

  def blue: Int

  def isLight: Boolean = (red + green + blue) / 3.0 > 0.5

  def isDark: Boolean = !isLight
}

case object Red extends Color {
  override def red: Int = 1

  override def green: Int = 0

  override def blue: Int = 0
}

case object Green extends Color {
  override def red: Int = 0

  override def green: Int = 1

  override def blue: Int = 0
}

case object Blue extends Color {
  override def red: Int = 0

  override def green: Int = 0

  override def blue: Int = 1
}

case object Yellow extends Color {
  override def red: Int = 1

  override def green: Int = 1

  override def blue: Int = 0
}

final case class CustomColor(red: Int, green: Int, blue: Int) extends Color
