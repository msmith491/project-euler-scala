package project_euler

import java.io.File
import scala.io.Source

object Problem22 {
  println("Names Scores")

  val letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    .split("")
    .zipWithIndex
    .toMap

  def getNameValue(name: String): Long = {
    name
      .map(x => letters(x.toString) + 1)
      .reduce(_ + _)
  }

  val filename = "src/main/resources/names_22.txt"

  val result = Source
    .fromFile(filename)
    .getLines()
    .toList(0)
    .replaceAll("\"", "")
    .split(",")
    .sorted
    .zipWithIndex
    .map { case (elem, index) => (getNameValue(elem) * (index + 1)) }
    .reduce(_ + _)

  println(result)
}

