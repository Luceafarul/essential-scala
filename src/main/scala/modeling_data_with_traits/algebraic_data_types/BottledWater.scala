package modeling_data_with_traits.algebraic_data_types

trait BottledWater {
  def size: Int

  def source: Source

  def carbonated: Boolean
}

sealed trait Source

case object Spring extends Source

case object Well extends Source

case object Tap extends Source
