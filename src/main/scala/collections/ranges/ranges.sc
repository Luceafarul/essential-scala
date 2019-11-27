val subjects = List("Noel", "The cat", "The dog")
val noelVerbs = List("wrote", "chased", "slept on")
val catVerbs = List("meowed at", "chased", "slept on")
val dogVerbs = List("barked at", "chased", "slept on")
val wroteObjects = List("the book", "the letter", "the code")
val chasedObjects = List("the ball", "the dog", "the cat")
val sleptOnObjects = List("the bed", "the mat", "the trait")
val meowedObjects = List("Noel", "the door", "the food cupboard")
val barkedObjects = List("the postman", "the car", "the cat")

val result = subjects.flatMap { subject =>
  subject match {
    case "Noel" => noelVerbs.flatMap { verb =>
      verb match {
        case "wrote" => wroteObjects.map(obj => s"$subject $verb $obj")
        case "chased" => chasedObjects.map(obj => s"$subject $verb $obj")
        case "slept on" => sleptOnObjects.map(obj => s"$subject $verb $obj")
        case _ => List.empty
      }
    }
    case "The cat" => catVerbs.flatMap { verb =>
      verb match {
        case "meowed at" => meowedObjects.map(obj => s"$subject $verb $obj")
        case "chased" => chasedObjects.map(obj => s"$subject $verb $obj")
        case "slept on" => sleptOnObjects.map(obj => s"$subject $verb $obj")
        case _ => List.empty
      }
    }
    case "The dog" => dogVerbs.flatMap { verb =>
      verb match {
        case "barked at" => barkedObjects.map(obj => s"$subject $verb $obj")
        case "chased" => chasedObjects.map(obj => s"$subject $verb $obj")
        case "slept on" => sleptOnObjects.map(obj => s"$subject $verb $obj")
        case _ => List.empty
      }
    }
    case _ => List.empty
  }
}