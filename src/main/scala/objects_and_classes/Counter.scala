package objects_and_classes

case class Counter(count: Int = 0) {
  def inc: Counter = copy(count + 1)

  def dec: Counter = copy(count - 1)

  def adjust(adder: Adder): Counter = copy(adder.add(count))
}

class Adder(amount: Int) {
  def add(i: Int): Int = amount + i
}
