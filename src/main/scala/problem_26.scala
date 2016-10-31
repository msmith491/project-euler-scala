package project_euler

import scala.collection.mutable

object Problem26 {
  println("Reciprocal cycles")

  def longestDecimalSeq(n: Int): Int = {
    var seqLen = 0

    for (dem <- (1 to n)) {

      val l = getSeq(dem, n)

      if (l > seqLen) {
        seqLen = l
      }
    }
    seqLen
  }

  def getSeq(i: Int, n: Int): Int = {
    var found = mutable.Seq.fill(n)(0)
    var v = 1
    var p = 0

    while (found(v) == 0 && v != 0) {
      found(v) = p
      v *= 10
      v %= i
      p += 1
    }
    // println(p - found(v))
    p - found(v)
  }

  println(longestDecimalSeq(1000))
}

