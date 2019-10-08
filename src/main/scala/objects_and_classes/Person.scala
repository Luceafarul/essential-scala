package objects_and_classes

case class Person(firstName: String, lastName: String)

object Person {
  def apply(name: String): Person = {
    val splitName = name.split(" ")
    val firstName = splitName(0)
    val lastName = splitName(1)
    Person(firstName, lastName)
  }
}
