package project_euler

import scala.collection.mutable

object Problem31 {
  println("Coin sums")


  def count(s: Seq[Int], m: Int, n: Int): Int = {
    (n, m) match {
      case (i, _) if i == 0 => 1
      case (i, _) if i < 0 => 0
      case (i, j) if i >= 1 && j <= 0 => 0
      case (i, j) => count(s, j - 1, i) + count(s, j, i - s(j - 1))
    }
  }

  val coins = Seq(1, 2, 5, 10, 20, 50, 100, 200)
  println(count(coins, coins.length, 200))
}
