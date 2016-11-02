package project_euler

import scala.collection.mutable

object Problem30 {
  println("Digit fifth powers")

  def powerDigits(num: Long, pow: Int): Long = {
    num
      .toString
      .map(_.asDigit)
      .map(x => scala.math.pow(x, pow))
      .map(_.toLong)
      .reduce(_ + _)
  }

  val result = (2 until 1000000)
    .filter(x => x == powerDigits(x, 5))
    .reduce(_ + _)

  println(result)
}

