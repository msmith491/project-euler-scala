package project_euler

import scala.math.sqrt
import scala.collection.mutable.ListBuffer

object Problem12 {
  println("Highly Divisible Triangular Number")

  var result = Stream.from(1)
    .map(getTriagsForIndex)
    .map(x => (x, getFactors(x)))
    .filter(z => z._2 > 500)
    .take(1)
  println(result.last._1)

  def getTriagsForIndex(index: Int): Long = {
    (index to 0 by -1).reduceLeft(_ + _)
  }

  def getFactors(num: Long): Long = {
    num match {
      case 1 => return 1
      case _ => ()
    }
    var curr = num
    var div = 2
    var divs = 0
    while (div <= sqrt(num)) {
      num % div match {
        case 0 => divs += 1
        case _ => ()
      }
      div += 1
    }
    (divs * 2) + 2
  }
}

