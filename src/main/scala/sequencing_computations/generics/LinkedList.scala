package sequencing_computations.generics

import scala.annotation.tailrec

sealed trait LinkedList[A] {
  def length: Int = {
    @tailrec
    def loop(l: LinkedList[A], acc: Int): Int = l match {
      case Nil() => acc
      case Cons(_, t) => loop(t, acc + 1)
    }

    loop(this, 0)
  }

  def contains(e: A): Boolean = this match {
    case Nil() => false
    case Cons(h, t) => if (h == e) true else t.contains(e)
  }

  def apply(index: Int): Result[A] = {
    @tailrec
    def loop(l: LinkedList[A], n: Int): Result[A] = l match {
      case Nil() => Failure("Index out of bound")
      case Cons(h, t) => if (n == 0) Success(h) else loop(t, n - 1)
    }

    loop(this, index)
  }

  def fold[B](end: B, f: (A, B) => B): B = this match {
    case Nil() => end
    case Cons(h, t) => f(h, t.fold(end, f))
  }

  def map[B](f: A => B): LinkedList[B] = this match {
    case Nil() => Nil[B]()
    case Cons(h, t) => Cons(f(h), t.map(f))
  }
}

final case class Cons[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

final case class Nil[A]() extends LinkedList[A]
