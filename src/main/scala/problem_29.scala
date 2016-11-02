package project_euler

import scala.collection.mutable
import scala.BigInt

object Problem29 {
  println("Distinct powers")

  def distinctPowers(a: Int, b: Int): Int = {
    var results: mutable.Set[BigInt] = mutable.Set()
    for (x <- (2 to a); y <- (2 to b)) {
      results.add(BigInt(x).pow(y))
      results.add(BigInt(y).pow(x))
    }
    // println(results.to[Seq].sorted)
    results.size
  }

  println(distinctPowers(100, 100))
}

