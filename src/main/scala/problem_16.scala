package project_euler

import scala.BigInt

object Problem16 {
  println("Power Digit Sum")

  val num = BigInt(2)
    .pow(1000)
    .toString
    .foldLeft(0L) {(acc, it) => acc + it.asDigit}

  println(num)
}

