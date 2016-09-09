package project_euler

object Problem19 {
  println("Counting Sundays")

  val dow = Array("monday", "tuesday", "wednesday",
                  "thursday", "friday", "saturday", "sunday")

  def isLeapYear(y: Int): Boolean = {
    y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)
  }

  def dayOfWeek(d: Int): String = {
    val i = d % 7
    dow(i)
  }

  def totalFirstSundays(y: Int, d: Int, start: Int): Int = {

    if (y < 1900) {
      throw new IllegalStateException("The year needs to be >= 1900")
    }

    var sun_count = 0
    var total_days = 0
    val iter = y - start
    val months = Array(("jan", 31),
                       ("feb", 28),
                       ("mar", 31),
                       ("apr", 30),
                       ("may", 31),
                       ("jun", 30),
                       ("jul", 31),
                       ("aug", 31),
                       ("sep", 30),
                       ("oct", 31),
                       ("nov", 30),
                       ("dec", 31))

    for (year <- 0 until iter; (month, days) <- months) {
      if (dayOfWeek(total_days + 1) == "sunday") {
        sun_count += 1
      }
      if (month == "feb") {
        if (isLeapYear(year + start)) {
          total_days += days + 1
        } else {
          total_days += days
        }
      } else {
        total_days += days
      }
    }
    sun_count
  }

  println(totalFirstSundays(2001, 0, 1901))
}

