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
      case x if x.charAt(0) == 'L' => (-1, Integer.parseInt(x.substring(1)))
      case x if x.charAt(0) == 'R' => (1, Integer.parseInt(x.substring(1)))
    }.foldLeft((0, 50))((acc, n) => {
      val clicks = n._2 % 100
      val turns = n._2/100
      def isAt0(): Boolean = {
        acc._2+ (clicks *n._1) == 0 || acc._2+ (clicks *n._1) == 100
      }
      val relativeDial = acc._2+ (clicks * n._1)
      val additionalTurn = if((isAt0() && acc._2 != 0) || (relativeDial <0 && acc._2 != 0) || relativeDial > 99) 1 else 0
      val dial = if(relativeDial <0) 100+relativeDial else if(relativeDial>99) relativeDial -100 else relativeDial

      print(s"The dial is rotated $n to point at $dial ")

      println( s"during this rotation it points ${turns + additionalTurn} times")


      (acc._1 + turns + additionalTurn, dial)
    })._1
  }
}
