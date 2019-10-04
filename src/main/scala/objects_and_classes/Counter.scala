package objects_and_classes

class Counter(val count: Int = 1) {
  def inc: Counter = new Counter(count + 1)

  def dec: Counter = new Counter(count - 1)

  def adjust(adder: Adder): Counter = new Counter(adder.add(count))
}

class Adder(amount: Int) {
  def add(i: Int): Int = amount + i
}
