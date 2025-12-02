package dev.gabrielsson

import scala.math.BigDecimal.double2bigDecimal

class Day2 extends Inputs {

  def part1(input: String): String = {
    input
      .split(",")
      .map(_.split("-"))
      .flatMap(t => t(0).toLong to t(1).toLong)
      .map(_.toString)
      .filter(_.length % 2 == 0)
      .filter(s => {
        val t = s.splitAt(s.length/2)
        t._1.equals(t._2)
      })
      .map(_.toLong).sum.toString
  }

  def part2(input: String): String = {
    input
      .split(",")
      .map(s => s.split("-"))
      .flatMap(t => t(0).toLong to t(1).toLong)
      .map(_.toString)
      .filter(splitsEqual)
      .tapEach(println)
      .map(_.toLong)
      .sum.toString
  }

  private def splitsEqual(s: String): Boolean = {
    (1 until s.length)
      .map(s.grouped)
      .map(_.toList)
      .exists(groups => groups.forall(group => group == groups.head))
  }
}
