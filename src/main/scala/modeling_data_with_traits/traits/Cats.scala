package modeling_data_with_traits.traits

sealed trait Feline {
  def color: String

  def sound: String = "roar"

  def dinner: Food

  def dinners: Food = this match {
    case Cat(_, food) => CatFood(food)
    case _: Lion => Antelope
    case _: Tiger => TigerFood
    case _: Panther => Licorice
  }
}

final case class Cat(color: String, food: String) extends Feline {
  override def sound: String = "meow"

  override def dinner: Food = CatFood(food)
}

final case class Lion(color: String, maneSize: Int) extends Feline {
  override def dinner: Food = Antelope
}

final case class Tiger(color: String) extends Feline {
  override def dinner: Food = TigerFood
}

final case class Panther(color: String) extends Feline {
  override def dinner: Food = Licorice
}
