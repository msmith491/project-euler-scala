package project_euler

import scala.math.sqrt

object Problem3 {
  val num = 600851475143L
  println("Largest Prime Factor")
  val result = Stream.from(1)
    .takeWhile(_ <= sqrt(num / 2))
    .filter(x => num % x == 0)
    .filter(x => is_prime(x))
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

