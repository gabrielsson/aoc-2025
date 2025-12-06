package dev.gabrielsson

class Day3 extends Inputs {

  def part1(input: Seq[String]): Int = {
    input
      .map(s => {
        val (largest, index) = findLargest(s)
        val secondLargest = findSecondLargest(s, index)
        s"$largest$secondLargest".toInt
      })
      .tapEach(println)
      .sum
  }

  def findLargest(digits: String): (Int, Int) = {
    val arr = digits.split("").map(_.toInt).zipWithIndex.sortBy(x => (-x._1,x._2 ))
    if (arr.head._2 == digits.length-1) {
      arr(1)
    } else {
      arr.head
    }
  }

  def findSecondLargest(str: String, i: Int): Int = {
    str.substring(i+1).split("").map(_.toInt).sorted.reverse.head
  }

  def findLargest12(digits: String, index: Int): (Int, Int) = {
    val arr = digits.split("").map(_.toInt).zipWithIndex.sortBy(x => (-x._1,x._2 ))
    if (arr.head._2 == digits.length-index) {
      (arr(1)._1, arr(1)._2)
    } else {
      (arr.head._1, arr.head._2)
    }
  }


  def part2(input: Seq[String]): Long = {
    input
      .map(s => {
        val (largest, index) = findLargest12(s.substring(0,s.length-2), 0)
        (0 to 11).foldLeft((Array[Int](), index))((acc, i) =>{
        val (second, secondIndex) = findLargest12(s.substring(acc._2 + 1), i)
          (acc._1:+second, secondIndex)
        })._1.mkString("")
      })

      .tapEach(println).map(_.toLong).sum
  }
}


