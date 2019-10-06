package objects_and_classes

class Person(val firstName: String, val lastName: String)

object Person {
  def apply(name: String): Person = {
    val splitName = name.split(" ")
    val firstName = splitName(0)
    val lastName = splitName(1)
    new Person(firstName, lastName)
  }
}
