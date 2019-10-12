package modeling_data_with_traits.algebraic_data_types

sealed trait TrafficLight {
  def action: String = this match {
    case Red => "stop"
    case Yellow => "ready"
    case Green => "go"
  }

  def next: TrafficLight
}

object TrafficLight {
  def next(light: TrafficLight): TrafficLight = light match {
    case Red => Yellow
    case Yellow => Green
    case Green => Red
  }
}

case object Red extends TrafficLight {
  override def next: TrafficLight = Yellow
}

case object Yellow extends TrafficLight {
  override def next: TrafficLight = Green
}

case object Green extends TrafficLight {
  override def next: TrafficLight = Red
}
