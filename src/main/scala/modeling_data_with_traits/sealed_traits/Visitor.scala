package modeling_data_with_traits.sealed_traits

import java.util.Date

sealed trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime - createdAt.getTime
}

final case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

final case class User(id: String, email: String, createdAt: Date = new Date()) extends Visitor
