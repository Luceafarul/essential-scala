package modeling_data_with_traits.traits

sealed trait Food

case object Antelope extends Food
case object TigerFood extends Food
case object Licorice extends Food
final case class CatFood(food: String) extends Food
