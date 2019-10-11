package modeling_data_with_traits.algebraic_data_types

sealed trait TrafficLight

object TrafficLight {
  def action(trafficLight: TrafficLight): String = trafficLight match {
    case Red => "stop"
    case Yellow => "ready"
    case Green => "go"
  }
}

case object Red extends TrafficLight

case object Yellow extends TrafficLight

case object Green extends TrafficLight
