package project_euler

import scala.math.pow
import scala.util.control.Breaks.{breakable,break}

object Problem9 {
  println("Special Pythagorean Triplet")
  breakable {
    for (a <- 100 to 1000; b <- 100 to 1000; c <- 100 to 1000) {
      if (a + b + c == 1000 && isPythTrip(a, b, c)) {
        println(a * b * c)
        break
      }
    }
  }
  def isPythTrip(a: Int, b: Int, c: Int): Boolean = {
    pow(a, 2) + pow(b, 2) == pow(c, 2)
  }
}

