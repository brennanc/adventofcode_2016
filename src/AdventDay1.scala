/**
  * Created by qpr049 on 12/5/16.
  */
object AdventDay1 {

  var horiz_dist = 0
  var vert_dist = 0
  var facing_dir = 'N'
  def moveA(instr : String): Unit = {
    val dist = instr.substring(1).toInt
    val prior_dir = facing_dir
    if (instr(0) == 'L') {
      facing_dir = facing_dir match {
        case 'N' => horiz_dist -= dist; 'W'
        case 'E' => vert_dist += dist; 'N'
        case 'S' => horiz_dist += dist; 'E'
        case 'W' => vert_dist -= dist; 'S'
      }
    } else {
      facing_dir = facing_dir match {
        case 'N' => horiz_dist += dist; 'E'
        case 'E' => vert_dist -= dist;  'S'
        case 'S' => horiz_dist -= dist; 'W'
        case 'W' => vert_dist += dist;  'N'
      }
    }
//    print (instr + " => was: " + prior_dir + ", to: " + facing_dir + "; vert_dist=" + vert_dist + "; horiz_dist=" + horiz_dist + "\n")
  }

  val tuples = scala.collection.mutable.Set[(Int, Int)]()
  def moveTracker(type_displacement : String, displacement : Int): Unit = {
    /*
    val incrementor = if (displacement < 0) -1 else 1
    object dist_to_update = if (type_displacement == "H") horiz_dist else vert_dist
    for (i <- 0 until math.abs(displacement)) {
      dist_to_update += incrementor;
      println((horiz_dist, vert_dist))
      if (tuples.contains((horiz_dist, vert_dist))) {
        val answer = math.abs(vert_dist) + math.abs(horiz_dist)
        println("DAY1 PARTB = " + answer)
      } else {
        tuples += ((horiz_dist, vert_dist))
      }
    }
    */
    /*
    if (type_displacement == "H") {
      for (i <- 0 until math.abs(displacement)) {
        horiz_dist += incrementor;
        println((horiz_dist, vert_dist))
        if (tuples.contains((horiz_dist, vert_dist))) {
          val answer = math.abs(vert_dist) + math.abs(horiz_dist)
          println("DAY1 PARTB = " + answer)
        } else {
          tuples += ((horiz_dist, vert_dist))
        }
      }
    }
    if (type_displacement == "V") {
      for (i <- 0 until math.abs(displacement)) {
        vert_dist += incrementor;
        println((horiz_dist, vert_dist))
        if (tuples.contains((horiz_dist, vert_dist))) {
          val answer = math.abs(vert_dist) + math.abs(horiz_dist)
          println("DAY1 PARTB = " + answer)
        } else {
          tuples += ((horiz_dist, vert_dist))
        }
      }
    }
    */
  }

  def moveB(instr : String): Unit = {
    val dist = instr.substring(1).toInt
    val prior_dir = facing_dir
    if (instr(0) == 'L') {
      facing_dir = facing_dir match {
        case 'N' => moveTracker("H", -dist); 'W'
        case 'E' => moveTracker("V", dist); 'N'
        case 'S' => moveTracker("H", dist); 'E'
        case 'W' => moveTracker("V", -dist); 'S'
      }
    } else {
      facing_dir = facing_dir match {
        case 'N' => moveTracker("H", dist); 'E'
        case 'E' => moveTracker("V", -dist);  'S'
        case 'S' => moveTracker("H", -dist); 'W'
        case 'W' => moveTracker("V", dist);  'N'
      }
    }
    print (instr + " => was: " + prior_dir + ", to: " + facing_dir + "; horiz_dist=" + horiz_dist + "; vert_dist=" + vert_dist + "\n")
  }


  def main(args: Array[String]): Unit = {
    val instructions_input = "L1, L3, L5, L3, R1, L4, L5, R1, R3, L5, R1, L3, L2, L3, R2, R2, L3, L3, R1, L2, R1, L3, L2, R4, R2, L5, R4, L5, R4, L2, R3, L2, R4, R1, L5, L4, R1, L2, R3, R1, R2, L4, R1, L2, R3, L2, L3, R5, L192, R4, L5, R4, L1, R4, L4, R2, L5, R45, L2, L5, R4, R5, L3, R5, R77, R2, R5, L5, R1, R4, L4, L4, R2, L4, L1, R191, R1, L1, L2, L2, L4, L3, R1, L3, R1, R5, R3, L1, L4, L2, L3, L1, L1, R5, L4, R1, L3, R1, L2, R1, R4, R5, L4, L2, R4, R5, L1, L2, R3, L4, R2, R2, R3, L2, L3, L5, R3, R1, L4, L3, R4, R2, R2, R2, R1, L4, R4, R1, R2, R1, L2, L2, R4, L1, L2, R3, L3, L5, L4, R4, L3, L1, L5, L3, L5, R5, L5, L4, L2, R1, L2, L4, L2, L4, L1, R4, R4, R5, R1, L4, R2, L4, L2, L4, R2, L4, L1, L2, R1, R4, R3, R2, R2, R5, L1, L2";
    val instructions = instructions_input.split(", ")

    val doPartA = false
    val doPartB = true

    if (doPartA) {
      instructions.foreach(i => moveA(i))
      print(math.abs(vert_dist) + math.abs(horiz_dist))
    }
    if (doPartB) {
      instructions.foreach(i => moveB(i))
    }
  }
}
