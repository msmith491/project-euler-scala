package project_euler

import scala.collection.mutable.ListBuffer

object Problem5 {
  println("Smallest Multiple")
  val result = Stream.from(2520, 2520)
    .filter(x => divisible(x))
    .take(1)
    .mkString
  println(result)
  def divisible(x: Long): Boolean = {
    (20 to 1 by -1)
      .map(y => x % y == 0)
      .takeWhile(_ == true)
      .length == 20
  }
}

