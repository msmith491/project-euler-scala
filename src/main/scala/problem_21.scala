package project_euler

object Problem21 {
  println("Amicable Numbers")

  def calcAmicable(num: Int): Int = {
    num match {
      case 1 => 1
      case _ => (1 to num / 2)
        .filter(x => num % x == 0)
        .reduce(_ + _)
    }
  }

  def isAmicable(num: Int): Boolean = {
    val am = calcAmicable(num)
    am == num match {
      case true => false
      case false => num == calcAmicable(am)
    }
  }

  val result = (1 until 10000)
    .filter(isAmicable(_))
    .reduce(_ + _)
  println(result)
}

