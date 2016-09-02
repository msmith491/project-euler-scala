package project_euler

import scala.math.pow

object Problem7 {
  println("10001st Prime")
  val result = Stream.from(2)
    .filter(y => is_prime(y))
    .take(10001)
    .max
  println(result)
  def is_prime(x: Long): Boolean = {
    x match {
      case 1 => true
      case 2 => true
      case 3 => true
      case y => {
        (y % 2 == 0 || y % 3 == 0) match {
          case true => false
          case z => {
            var curr = 5
            while (true) {
              curr * curr > x match {
                case true => return true
                case false => {
                  if (x % curr == 0 || x % (curr + 2) == 0) {
                    return false
                  }
                }
              }
              curr += 6
            }
            true
          }
        }
      }
    }
  }
}

