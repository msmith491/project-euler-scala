package project_euler

object Problem17 {
  println("Number Letter Counts")

  val ones = List("one", "two", "three", "four", "five", "six", "seven",
                  "eight", "nine")

  val ten = "ten"

  val teens = List("eleven", "twelve", "thirteen", "fourteen", "fifteen",
                   "sixteen", "seventeen", "eighteen", "nineteen")

  val twenty_plus = List("twenty", "thirty", "forty", "fifty", "sixty",
                         "seventy", "eighty", "ninety")

  val hundred = "hundred"

  val thousand = "thousand"

  val and = " and "

  def getNumber(n: Int): String = {

    n match {
      case _ if 1 to 9 contains n => ones(n - 1)
      case 10 => ten
      case _ if 11 to 19 contains n => teens(n - 11)
      case _ if 20 to 99 contains n => {
        val t_digit = n / 10
        val o_digit = n % 10
        var s = ""

        t_digit match {
          case 1 => s = ten
          case _ => s = twenty_plus(t_digit - 2)
        }

        o_digit match {
          case _ if o_digit > 0 => s += " " + ones(o_digit - 1)
          case _ => ""
        }

        s
      }
      case _ if 100 to 999 contains n => {
        val h_digit = n / 100
        val t_digit = (n % 100) / 10
        val o_digit = (n % 10)

        var s = ""

        s = s + ones(h_digit - 1) + " " + hundred

        (t_digit, o_digit) match {
          case (0, 0) => s
          case (0, _) if o_digit > 0 => s += and + ones(o_digit - 1); s
          case (1, 0) => s += and + ten; s
          case (1, _) if o_digit > 0 => s += and + teens(o_digit - 1); s
          case (_, _) => s += and + twenty_plus(t_digit - 2); s
        }

        (o_digit > 0, t_digit > 1) match {
          case (true, true) => s += " " + ones(o_digit - 1); s
          case _ => s
        }
      }
      case 1000 => "one thousand"
    }
  }

  val result = (1 to 1000)
    .map(getNumber)
    .reduce(_ + _)
    .replaceAll("\\s", "")
    .length

  println(result)
}

