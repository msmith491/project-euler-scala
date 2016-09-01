package project_euler

import scala.math.pow

object Problem6 {
  println("Sum Square Difference")
  println(-sumOfSquares(100) + squareOfSum(100))
  def sumOfSquares(x: Int): Int = {
    (1 to x)
      .map(y => pow(y, 2).toInt)
      .foldLeft(0) { (acc, it) => acc + it }
  }
  def squareOfSum(x: Int): Int = {
    pow((1 to x)
      .foldLeft(0) { (acc, it) => acc + it }, 2)
      .toInt
  }
}

