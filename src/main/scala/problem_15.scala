package project_euler

object Problem15 {
  println("Lattice Paths")

  def path(grid: Array[Int]): Int = {
    var paths = 0

    if (grid == Array(0)) { return 1 }

    if (grid(0) != 0) {
      paths = paths + path(Array.fill[Int](grid(0) - 1)(grid(1)))
    }

    if (grid(1) != 0) {
      paths = paths + path(Array.fill[Int](grid(0))(grid(0) - 1))
    }
    paths
  }

  def iterPath(s: Int): Long = {

    var v = Array.fill[Long](s + 1)(1)

    for (i <- 1 to s) {
      for (j <- 1 until i) {
        v(j) += v(j - 1)
      }
      v(i) = 2 * v(i - 1)
    }
    v(s)
  }

  println(iterPath(20))
}

