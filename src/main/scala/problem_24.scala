package project_euler

import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.collection.mutable.Seq
import scala.util.control.Breaks._

object Problem24 {
  println("Lexicographic permutations")

  def swap[A](array: Seq[A], a: Int, b: Int): Unit = {
    val tmp = array(a)
    array(a) = array(b)
    array(b) = tmp
  }

  def permutations(num: Int, amount: Int): ListBuffer[Long] = {
    // var a = (0 until num).to[ArrayBuffer]
    var a = ArrayBuffer.range(0, num)
    val n = a.length
    var result: ListBuffer[Long] = ListBuffer()


    def permHeap(n: Int, v: ArrayBuffer[Int], r: ListBuffer[Long]): Unit = {
      n match {
        case 1 => r.append(v.map(_.toString).reduce(_ + _).toLong)
        case _ => {

          var i = 0
          breakable {
            while (true) {
              permHeap(n - 1, v, r)
              if (i == n - 1) {
                break;
              }
              n % 2 match {
                case 0 => swap(v, i, n - 1)
                case _ => swap(v, 0, n - 1)
              }
              i += 1
            }
          }
        }
      }
    }

    def lexPerm(v: ArrayBuffer[Int]): Boolean = {
      var index = v.length - 1
      while (index > 0 && v(index - 1) >= v(index)) {
        index -= 1;
      }
      index <= 0 match {
        case true => false
        case _ => {
          var succ = v.length - 1
          while (v(succ) <= v(index - 1)) {
            succ -= 1
          }
           swap(v, index - 1, succ)

           succ = v.length - 1;
           while (index < succ) {
             swap(v, index, succ)
             index += 1;
             succ -= 1;
           }
           true
        }
      }
    }

    def lexPerms(n: Int, v: ArrayBuffer[Int]): ListBuffer[Long] = {
      var result: ListBuffer[Long] = ListBuffer()
      result.append(v.map(_.toString).reduce(_ + _).toLong)
      for (x <- (0 until n)) {
        lexPerm(v)
        result.append(v.map(_.toString).reduce(_ + _).toLong)
      }
      result
    }

    // permHeap(n, a, result);

    // Switched to doing lexical permutations directly instead of HEAP
    // algorithm permutations that I then sort and index.  This decreases
    // total computation time from ~30 seconds to ~2 seconds since we're not
    // calculating a bunch of permutations that we don't care about
    result = lexPerms(amount, a)
    result
  }

  var perms = permutations(10, 1000000 - 1);
  println(perms.last)
}

