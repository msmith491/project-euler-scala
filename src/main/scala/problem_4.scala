package project_euler

import scala.collection.mutable.ListBuffer

object Problem4 {
  println("Palindrome Product")
  val result = Stream.from(999, -1)
    .takeWhile(_ >= 800)
    .map(x => (x, Stream.from(999, -1).takeWhile(_ >= 800)))
    .map( { case (x: Int, y: Stream[Int]) => {
      var list = ListBuffer.empty[Int]
      for (it <- y) {
        if (is_palindrome(it * x)) {
          list.append(it * x)
        }
      }
      if (list.length == 0) list.append(0)
      list.max
    }})
    .max
  println(result)
  def is_palindrome(x: Int): Boolean = {
    x.toString == x.toString.reverse
  }
}

