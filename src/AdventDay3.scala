import scala.io.Source
import scala.collection.mutable.ListBuffer

object AdventDay3 {

  def partA(): Unit = {
    var validTriangles = 0
    for (line <- Source.fromFile("src/day3_input.txt").getLines()) {
      var arr = new ListBuffer[Int]()
      val values = line.trim().split("\\s+").foreach(i => arr += i.toInt)
      val sortedarr = arr.sorted
      print("%d, %d, %d".format(sortedarr(0), sortedarr(1), sortedarr(2)))
      if ((sortedarr(0) + sortedarr(1)) > sortedarr(2)) {
        println(" => TRIANGLE!")
        validTriangles += 1
      } else {
        println(" => NOT_TRIANGLE!")
      }
    }
    println(validTriangles)
  }

  def partB(): Unit = {
    var validTriangles = 0
    var groupCount = 0
    var arr = new ListBuffer[Int]()
    for (line <- Source.fromFile("src/day3_input.txt").getLines()) {
      val values = line.trim().split("\\s+").foreach(i => arr += i.toInt)
      groupCount += 1
      if (groupCount == 3) {
        val t1 = List(arr(0), arr(3), arr(6)).sorted
        val t2 = List(arr(1), arr(4), arr(7)).sorted
        val t3 = List(arr(2), arr(5), arr(8)).sorted
        if (t1(0) + t1(1) > t1(2)) validTriangles += 1
        if (t2(0) + t2(1) > t2(2)) validTriangles += 1
        if (t3(0) + t3(1) > t3(2)) validTriangles += 1
        groupCount = 0
        arr.remove(0, arr.size)
      }
    }
    println(validTriangles)
  }

  def main(args: Array[String]): Unit = {
    partB()
  }
}