package objects_and_classes

object ChipShop {
  def willServe(cat: Cat): Boolean = cat match {
    case Cat(_, _, "chips" | "Chips") => true
    case _ => false
  }
}
