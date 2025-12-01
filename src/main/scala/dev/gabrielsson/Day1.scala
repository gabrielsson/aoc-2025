package dev.gabrielsson

class Day1 extends Inputs {

  def part1(input: Seq[String]): Int = {
    input.map {
      case x if x.charAt(0) == 'L' => -Integer.parseInt(x.substring(1))
      case x if x.charAt(0) == 'R' => Integer.parseInt(x.substring(1))
    }.foldLeft((0, 50))((acc, n) => {
      var r = (acc._2 + n) % 100

      if (r < 0) {
        r = 100 + r
      }

      var l = if (r == 0)
        1
      else 0
      (acc._1 + l, r)
    })._1
  }

  def part2(input: Seq[String]): Int = {
    input.map {
      case x if x.charAt(0) == 'L' => -Integer.parseInt(x.substring(1))
      case x if x.charAt(0) == 'R' => Integer.parseInt(x.substring(1))
    }.foldLeft((0, 50))((acc, n) => {
      var r = (acc._2 + n) % 100
      var off = Math.abs((acc._2 + n))/100
      if (r < 0) {
        r = 100 + r
        off += 1
      }



      print(s"The dial is rotated $n to point at $r ")
      if(off > 0)
      println( s"during this rotation it points $off times")
      else println()


      (acc._1 + off, r)
    })._1
  }
}
