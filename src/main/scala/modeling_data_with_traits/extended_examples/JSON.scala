package modeling_data_with_traits.extended_examples

sealed trait JSON {
  def print: String = this match {
    case JsObjectEnd => "{}"
    case JsArrayEmpty => "[]"
    case JsNull => null
    case JsNumber(value) => value.toString
    case JsString(value) => s""""$value""""
    case JsBoolean(value) => value.toString
    case array @ JsArray(_, _) => s"[${seqToJson(array)}]"
    case obj @ JsObjectCell(_, _, _) => s"{ ${objectToJson(obj)} }"
  }

  private def objectToJson(obj: JsObject): String = obj match {
    case JsObjectCell(key, value, tail@JsObjectCell(_, _, _)) => s""""$key": ${value.print}, ${objectToJson(tail)}"""
    case JsObjectCell(key, value, JsObjectEnd) => s""""$key": ${value.print}"""
  }

  private def seqToJson(seq: JsArray): String = seq match {
    case JsArray(head, tail@JsArray(_, _)) => s"${head.print},${seqToJson(tail)}"
    case JsArray(head, JsArrayEmpty) => head.print
  }
}

sealed trait JsObject extends JSON

//final case class JsObject(cell: JsObjectCell) extends JSON

final case class JsObjectCell(key: String, value: JSON, tail: JsObject) extends JsObject

final case object JsObjectEnd extends JsObject

final case class JsString(value: String) extends JSON

final case class JsNumber(value: Int) extends JSON

final case class JsBoolean(value: Boolean) extends JSON

final case object JsNull extends JSON

sealed trait JsSeq extends JSON

final case class JsArray(head: JSON, tail: JsSeq) extends JsSeq

final case object JsArrayEmpty extends JsSeq
