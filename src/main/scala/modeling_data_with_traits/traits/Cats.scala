package modeling_data_with_traits.traits

trait Feline {
  def color: String

  def sound: String = "roar"
}

case class Cat(color: String, food: String) extends Feline {
  override def sound: String = "meow"
}

case class Lion(color: String, maneSize: Int) extends Feline

case class Tiger(color: String) extends Feline

case class Panther(color: String) extends Feline
