package project_euler

import scala.BigInt
import scala.annotation.tailrec

object Problem20 {
  println("Factorial Digit Sum")

  @tailrec
  def factorial(num: Int, acc: BigInt): BigInt = {
    num match {
      case 1 => acc
      case _ => factorial(num - 1, num * acc)
    }
  }

  val result = factorial(100, 1)
    .toString
    .map(_.asDigit)
    .reduce(_ + _)
  println(result)
}

