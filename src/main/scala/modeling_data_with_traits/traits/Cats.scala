package modeling_data_with_traits.traits

trait Feline {
  def color: String

  def sound: String = "roar"

  def dinner: Food
}

case class Cat(color: String, food: String) extends Feline {
  override def sound: String = "meow"

  override def dinner: Food = CatFood(food)
}

case class Lion(color: String, maneSize: Int) extends Feline {
  override def dinner: Food = Antelope
}

case class Tiger(color: String) extends Feline {
  override def dinner: Food = TigerFood
}

case class Panther(color: String) extends Feline {
  override def dinner: Food = Licorice
}
