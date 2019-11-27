package collections.ranges

object TestDistribution extends App {

  sealed trait Coin
  final case object Heads extends Coin
  final case object Tails extends Coin

  val fairCoin: Distribution[Coin] = Distribution.uniform(List(Heads, Tails))
  fairCoin.events.foreach(println)

  val threeFlips = for {
    c1 <- fairCoin
    c2 <- fairCoin
    c3 <- fairCoin
  } yield (c1, c2, c3)

  threeFlips.events.foreach(println)
}
