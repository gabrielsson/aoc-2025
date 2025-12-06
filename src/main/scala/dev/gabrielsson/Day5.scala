package dev.gabrielsson

case class LazyRange(start: Long, end: Long) {
  def contains(value: Long): Boolean = {

    value >= start && value <= end
  }

  def size(): Long = {
    end - start + 1
  }
}
class Day5 extends Inputs {

  def part1(input: Seq[String]): Int = {

-1

  }

  def part2(input: Seq[String]): Long = {
    val ranges = input.takeWhile(_.contains("-")).map(_.split("-")).map(r => LazyRange(r(0).toLong, r(1).toLong)).sortBy(_.start)
    val first = ranges.head
    val consolidated = ranges.tail.foldLeft(List(first))((acc, r) => {

      if (acc.head.contains(r.start) && acc.head.end < r.end)
        LazyRange(acc.head.start, r.end) +: acc.tail
      else if (acc.head.contains(r.start))
        acc
      else if (r.start - acc.head.start == 1)
        LazyRange(acc.head.start, r.end) +: acc.tail
      else
        r +: acc
    })
    consolidated.map(_.size()).sum




  }
}
