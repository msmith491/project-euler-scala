package project_euler

import scala.reflect.runtime.universe

import org.rogach.scallop._

object Main {
  def main(args: Array[String]) {
    val conf = new Conf(args)
    val num = conf.problem()
    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val module = runtimeMirror.staticModule(s"project_euler.Problem$num")
    if (conf.profile()) {
      time { runtimeMirror.reflectModule(module).instance }
    }
    else {
      runtimeMirror.reflectModule(module).instance
    }
  }

  def time[R](block: => R): R = {
      val t0 = System.nanoTime()
      val result = block    // call-by-name
      val t1 = System.nanoTime()
      println("Elapsed time: " + (t1 - t0) / 1000000 + " ms")
      result
  }

}

class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {
  val problem = opt[Int](required = true)
  val profile = opt[Boolean](required = false)
  verify()
}
