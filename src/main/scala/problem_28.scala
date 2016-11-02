package project_euler

import scala.collection.mutable

object Problem28 {
  println("Number spiral diagonals")

  def genDiags(side: Int): mutable.Seq[Int] = {

    var diags: mutable.Seq[Int] = mutable.Seq(1)
    var current = 1
    var add = 2
    var count = 0

    while (add < side) {
      count < 4 match {
        case true => {
          current += add
          diags = diags :+ current
          count += 1
        }
        case false => {
          count = 0
          add += 2
        }
      }
    }
    diags
  }

  println(genDiags(1001).reduce(_ + _))
}

