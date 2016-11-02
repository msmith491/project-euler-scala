package project_euler

import scala.collection.mutable

object Problem27 {
  println("Quadratic primes")

  def primes: mutable.Set[Long] = mutable.Set()

  def isPrime(x: Long): Boolean = {
    if (x <= 0) {
      return false
    }
    x match {
      case 1 => true
      case 2 => true
      case 3 => true
      case y => {
        if (primes.contains(x)) {
          return true
        }
        (y % 2 == 0 || y % 3 == 0) match {
          case true => false
          case z => {
            var curr = 5
            while (true) {
              curr * curr > x match {
                case true => {
                  primes.add(x)
                  return true
                }
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

  def consecPrimes(a: Int, b: Int): Int = {
    var n = 0
    while (isPrime(n * n + a * n + b)) {
      n += 1
    }
    n
  }

  var longest = 0
  var aResult = 0
  var bResult = 0
  for (a <- (-999 to 999); b <- (-1000 to 1000)) {
    val len = consecPrimes(a, b)
    if (longest <= len) {
      longest = len
      aResult = a
      bResult = b
    }
  }

  // println(longest, aResult, bResult, aResult * bResult)
  println(aResult * bResult)
}

