package project_euler

import scala.BigInt
import scala.annotation.tailrec

object Problem25 {
  println("1000-digit Fibonacci number")


  def fib(x: Long): BigInt = {

    @tailrec
    def helper(a: BigInt, b: BigInt, count: BigInt): BigInt = {
      count <= 0 match {
        case true => a
        case _ => helper(b, a+b, count-1)
      }
    }
    x <= 2 match {
      case true => x
      case _    => helper(0, 1, x)
    }
  }

  val result = Stream.from(0)
    .map(x => fib(x.toLong))
    .takeWhile(x => x.toString.length < 1000)
    .zipWithIndex
    .last
  println(result._2 + 1)
}

