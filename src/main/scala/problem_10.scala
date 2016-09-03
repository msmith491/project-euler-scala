package project_euler

import scala.math.{pow,sqrt}
import scala.collection.mutable.{ArrayBuffer,Map}

object Problem10 {
  println("Summation of Primes")
  val result = primes(2000000)
    .foldLeft(0L) { (a, it) => a + it }
  println(result)
  def primes(x: Int): Seq[Int] = {
    val pnum = (2 until x).to[ArrayBuffer]
    var pbool: ArrayBuffer[Boolean] = ArrayBuffer.fill[Boolean](x)(true)
    var ps = Map(pnum.zip(pbool).toMap.toSeq: _*)
    for (i <- 2 to sqrt(x).toInt) {
      ps(i) match {
        case true => {
          var j = i * i
          var index = 1
          while (j < x) {
            ps(j) =  false
            j = (i * i) + (i * index)
            index += 1
          }
        }
        case _ => {}
      }
    }
    ps.toSeq.filter(_._2 == true).map { case (k, _) => k }.sorted
  }
}

