package project_euler

object Problem1 {
  println("Multiples of 3 & 5")
  val result = (1 until 1000).map(x => f(x)).foldLeft(0) { (acc, it) => acc + it }
  println(result)
  def f(x: Int) = {
    if (x % 3 == 0 || x % 5 == 0) x else 0
  }
}

