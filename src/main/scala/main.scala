package project_euler

import scala.reflect.runtime.universe

import org.rogach.scallop._

object Main {
  def main(args: Array[String]) {
    val conf = new Conf(args)
    val num = conf.problem()
    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val module = runtimeMirror.staticModule(s"project_euler.Problem$num")
    runtimeMirror.reflectModule(module).instance
  }
}

class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {
  val problem = opt[Int](required = true)
  verify()
}
