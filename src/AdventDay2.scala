object AdventDay2 {

  def keypadPress(cur: Char, direction: Char): Char = {
    cur match {
      case '1' => direction match { case 'L' => '1' case 'R' => '2' case 'U' => '1' case 'D' => '4' }
      case '2' => direction match { case 'L' => '1' case 'R' => '3' case 'U' => '2' case 'D' => '5' }
      case '3' => direction match { case 'L' => '2' case 'R' => '3' case 'U' => '3' case 'D' => '6' }
      case '4' => direction match { case 'L' => '4' case 'R' => '5' case 'U' => '1' case 'D' => '7' }
      case '5' => direction match { case 'L' => '4' case 'R' => '6' case 'U' => '2' case 'D' => '8' }
      case '6' => direction match { case 'L' => '5' case 'R' => '6' case 'U' => '3' case 'D' => '9' }
      case '7' => direction match { case 'L' => '7' case 'R' => '8' case 'U' => '4' case 'D' => '7' }
      case '8' => direction match { case 'L' => '7' case 'R' => '9' case 'U' => '5' case 'D' => '8' }
      case '9' => direction match { case 'L' => '8' case 'R' => '9' case 'U' => '6' case 'D' => '9' }
    }
  }

  def keypadPressB(cur: Char, direction: Char): Char = {
    cur match {
      case '1' => direction match { case 'L' => '1' case 'R' => '1' case 'U' => '1' case 'D' => '3' }
      case '2' => direction match { case 'L' => '2' case 'R' => '3' case 'U' => '2' case 'D' => '6' }
      case '3' => direction match { case 'L' => '2' case 'R' => '4' case 'U' => '1' case 'D' => '7' }
      case '4' => direction match { case 'L' => '3' case 'R' => '4' case 'U' => '4' case 'D' => '8' }
      case '5' => direction match { case 'L' => '5' case 'R' => '6' case 'U' => '5' case 'D' => '5' }
      case '6' => direction match { case 'L' => '5' case 'R' => '7' case 'U' => '2' case 'D' => 'A' }
      case '7' => direction match { case 'L' => '6' case 'R' => '8' case 'U' => '3' case 'D' => 'B' }
      case '8' => direction match { case 'L' => '7' case 'R' => '9' case 'U' => '4' case 'D' => 'C' }
      case '9' => direction match { case 'L' => '8' case 'R' => '9' case 'U' => '9' case 'D' => '9' }
      case 'A' => direction match { case 'L' => 'A' case 'R' => 'B' case 'U' => '6' case 'D' => 'A' }
      case 'B' => direction match { case 'L' => 'A' case 'R' => 'C' case 'U' => '7' case 'D' => 'D' }
      case 'C' => direction match { case 'L' => 'B' case 'R' => 'C' case 'U' => '8' case 'D' => 'C' }
      case 'D' => direction match { case 'L' => 'D' case 'R' => 'D' case 'U' => 'B' case 'D' => 'D' }
    }
  }

  def keypadPressSequence(start : Char, seq: String): Char = {
    var s = start
    for (c <- seq) {
      s = keypadPressB(s, c)
    }
    s
  }

  def main(args: Array[String]): Unit = {
    val inputstr = """RRLLDDRLLDURLDUUDULDLRLDDDRLDULLRDDRDLUUDLLRRDURRLUDUDULLUUDRUURRDDDDURUULLDULRLRRRDLLLRDLRDULDLRUUDRURLULURUUDRLUUDRDURUUDDDRDLLRDLUDRLUUUUUULDURDRDDURLDDRLUUDLRURRDRLDRDLRRRLURULDLUUURDRLUULRDUDLDRRRDDLDDDRLRLLDRDUURDULUURRRRUDLLUDLDRLLRRULLLRDRDRRDRDRDUULUDLULRLLDRULURLURDLLDDRRLUDRDUULLDRULLLRLULUDDLURLUULDRUDRLDUUDDLLLRURDRLDRLUUUUUUDRUDLDLULULRRURRDDDUDRRRDDDLDDLRLLDDUULLUDRURDDDRDDLURRURULULUUDRLLUUDDDRUULRDLDLLRUUDRRLRRRULLRRURUDDUUDULDUDUUUDURUDUUDUDRULUDULRDUDUUUUDLLURDLRRUDURDDUULLDLLRDUDULRLRDURLRDRDLRDLRURUDURLULDDDLDRLULLRLURRLLDLRLLULLDUURUUDRULDDUDLDDR
LUURULURUURRRDLRDRDDDUDULRDDLUUDUUULRLRRLRUDDLDLURLRULUUDUUDLDRLLUURLUUURDUDLUULLUUDUUDRDUDUDURLLURDUDLDLDDLDUDRLLUULDDRUDDDRLRUDRDUDULLRRDLLDDLRLLLRLRURURLLDULUDDUULULDRRLUURDULRULUDULDULDULRULLLRRDRLDRLDUULLDDULRLUDLLLULDDLULLUULUURRULDLUULDRRUDDDLRDLULDULDRRDLRRRLRUDURUDDDUDDURRRLDUULRDDLRRRLRUULDDURDRDUULDLLULULDRDRUULDLULRUUDUDLUDRLRDURRRRLULURDRLLLUDRRRDRURRLRLLUURDLURLURDULURUDDULLDUUDDLRLUULRDUUDRDRUDRLUUUDURLLRDRRDRURDDDDULLDDUDLDUUDLRLURURLDRRDRDUDLRRDRUDRDLURRLLLULULULRUDDDULULULDDRRLULUUUURDDURURLDLDDDDDRULUUUULLUDDDRRLUULDUULRUUDUURRLLRDDRUURL
RRRLLLLUULLRRLLDRULULLLRDLLDLDDLURUDLULUULLRURLDULLUDULDRURDURLULLDUDDRLLRUURDLLULUURLULLDLRRDDDULUURRUDRDRDURULDLLURUDLLLDDUDLLLLRLDRDRDDRRDLUUDLLLULLLLLDDRDLULLLLRURRRUUUULLDLRDLDLRRRULRRRRLDLLRDURULDDLURURUULULDRDDDURLRDDRDULLUURUDUUUDRDRRLURULULRLUUDDRDULDRLULULUULRLDRLUDRRDDDRUDDRDDRDDRRLRDLRURDULULRRUUURDRRRDURDDRUDULUUDRDDLDRDDDULDLRDUULDUULRUDLRRDDDLLDDLLLRRDLDUULUULULURRULLRRUDUDRUDRRRLDLRLURRLUDLLLUUDDUDRURUUDDURDURULRLDUDRDLULDUDRUDDDR
DRDRRUUUUURRLUDLDLRUUULRLDLRRRDDUDLUUDUDDLRDUDLRRLLURUUDULLUDLULLDLLDDULUDDUDUULURLDLDDUUDDRDDRLUURLUUDUDUDURULLDRLDDRUDLURRRLDRLRULDDLDDLDDDULDUDDLLDULUUDUDDUULDRLDRLRURDULUDDRRLRRLRRDULDRRDUDUDRLDURRLRLRDLRLRRLRDDDRULLULULDUDDLDLULRLLURRRRULUULRUDLDLRDLLURURUUURDRRRLDDRLRLURDDURDDUURUUUDDLRUURRRDLLUULUDRLDDRDDDDUUDRLRRDULDULRDLLLRULULLRDRULLRDLRUUURRRURLRRDLDRDDLURLDLULLDUURRDULUUURRLLDDUUUULDDDDLRDDDRDLDLLUURLDDRULUDDRDDDLRDU
DRRRLURUDUDUULDLLURLUUDDRRRDUDLURLLDRRLLDDURULUDUURURULLRLDLLUURDLLDLLDLDLRUDLLLLDRLLUDLLDULDDRRURDRRLRLRRUURRUDURRLDRDLDURUULUDRLLURLUDURDULLRLLDLURLRRDLLLLUUDRDULLDLURDULDRDURRRLDRLURULULURLLLRRRUULRLRRDRDDDLULRLRRDLUDDUUUUUDRRDLDUDUURLDRRRLRUDRULDRLURUULRDLDDLRURDLURULRRLDURLDUURURULRDUDRRUDUDDLRLUURURULDDLULULULDULRRLRRURUURLRLLDRRLUDLUURDRRURRUUDULRLURRLRLRDDRURDDLRRDUDRLLUUUDULRDRULUURRLRLRDUDULDRDLLUDRDLLDRULDLUUURDDRDDUDDULLLDRRDDUDDDDLDDRLRULRRRURRDRULLDDDURDDLURRDDDUDLURRUDUDLLDDDLRUUDRLRRLRDUUUDDL"""

    val doPartA = false
    val doPartB = true

    if (doPartA) {
      var start = '5'
      for (seq <- inputstr.split("\\n")) {
        val result = keypadPressSequence(start, seq)
        print(result)
        start = result
      }
      println()
    }
    if (doPartB) {
      var start = '5'
      for (seq <- inputstr.split("\\n")) {
        val result = keypadPressSequence(start, seq)
        print(result)
        start = result
      }
      println()
    }
  }
}

