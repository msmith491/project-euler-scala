package project_euler

object Problem2 {
  println("Even Fibonacci Numbers")
  val result = Stream.from(1)
    .map(x => fib(x))
    .takeWhile(_ <= 4000000)
    .filter(x => x % 2 == 0)
    .foldLeft(0) { (acc, it) => acc + it }
  println(result)
  def fib(x: Int): Int = {
    x match {
      case 0 => 0
      case 1 => 1
      case 2 => 2
      case y => fib(y - 1) + fib(y - 2)
    }
  }
}

