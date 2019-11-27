package collections.ranges

final case class Distribution[A](events: List[(A, Double)]) {
  def map[B](f: A => B): Distribution[B] = Distribution(events.map {
    case (event, probability) => f(event) -> probability
  })

  def flatMap[B](f: A => Distribution[B]): Distribution[B] = Distribution(events.flatMap { case (event1, probability1) =>
    f(event1).events.map { case (event2, probability2) =>
      event2 -> (probability1 * probability2)
    }
  }).compact.normalize

  def normalize: Distribution[A] = {
    val totalWeight = (events map { case (_, probability) => probability }).sum
    Distribution(events map { case (event, probability) => event -> (probability / totalWeight) })
  }

  def compact: Distribution[A] = {
    val distinct = (events map { case (event, _) => event }).distinct

    def prob(event: A): Double = (events filter { case (e, _) => e == event } map { case (_, p) => p }).sum

    Distribution(distinct map { event => event -> prob(event) })
  }
}

object Distribution {
  def uniform[A](events: List[A]): Distribution[A] = {
    val probability = 1.0 / events.length
    Distribution(events map { event => event -> probability })
  }
}
