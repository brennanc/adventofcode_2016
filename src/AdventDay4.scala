import scala.io.Source
import collection.JavaConverters._
import scala.collection.mutable

object AdventDay4 {

  def main(args: Array[String]): Unit = {
    val pattern = "(\\d+)\\[(\\w+)\\]".r
    for (line <- Source.fromFile("src/day4_input.txt").getLines()) {
      val m = new java.util.TreeMap[Char, Int]().asScala

      val stuff = line.split("-")
      for (i <- 1 until stuff.size-1) {
        for (j <- 0 until stuff(i).size) {
          val c = stuff(i).charAt(j)
          val count = if (m.contains(c)) m(c) else 0
          m(c) = count + 1
        }
      }

      val sortedVals = mutable.MutableList[Char]()
      for (v <- m.
      for (k <- m.keys) {

      }

      val last = stuff(stuff.size-1)
      val mi = pattern.findAllIn(last)
      val secId = mi.group(1)
      val checksum = mi.group(2)

    }
  }
}