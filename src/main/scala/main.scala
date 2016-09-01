package project_euler

import org.rogach.scallop._

object Main {
  def main(args: Array[String]) {
    val conf = new Conf(args)
    conf.problem() match {
      case 1 => Problem1
      case 2 => Problem2
      case 3 => Problem3
      case _ => println("WHAAAAAAAT?")
    }
  }
}

class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {
  val problem = opt[Int](required = true)
  verify()
}
