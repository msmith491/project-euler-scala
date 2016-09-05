package project_euler

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Problem14 {
  println("Longest Collatz Sequence")

  val result = Stream
    .from(1)
    .map(x => x.toLong)
    .take(1000000)
    .map(x => (collatzSeqR2(x), x))
    .maxBy(_._1)
  println(result._2)

  @tailrec
  def collatzSeqR(num: Long, v: ListBuffer[Long] = ListBuffer()): ListBuffer[Long] = {
    num match {
      case 1 => {
        v += 1
        v
      }
      case _ => {
        v += num
        collatzSeqR(num % 2 match {
          case 0 => num / 2
          case _ => (num * 3) + 1
        }, v)
      }
    }
  }

  @tailrec
  def collatzSeqR2(num: Long, v: Int = 0): Long = {
    var v2 = v
    num match {
      case 1 => {
        v2 += 1
        v2
      }
      case _ => {
        v2 += 1
        collatzSeqR2(num % 2 match {
          case 0 => num / 2
          case _ => (num * 3) + 1
        }, v2)
      }
    }
  }
}

