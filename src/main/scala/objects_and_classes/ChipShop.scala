package objects_and_classes

object ChipShop {
  def willServe(cat: Cat): Boolean = cat.food.equalsIgnoreCase("chips")
}
