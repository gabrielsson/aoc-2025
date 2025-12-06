package dev.gabrielsson

class Day6 extends Inputs {
  case class Problem(numbers: Seq[Long], kind: String) {
    def result() = {
      kind match {
        case "*" => numbers.product
        case "+" => numbers.sum
      }
    }
  }


  def part1(input: Seq[String]): Long = {
    val arrays = input
      .map(s => s.split(" ").filter(!_.isEmpty)).map(s => s.map(_.trim))
    val noOfProblems = arrays.head.length

    (0 until noOfProblems)
      .map(i => arrays.map(_(i)))
      .map(s => Problem(s.slice(0, s.size-1).map(_.toInt), s.last))
      .map(_.result())
      .sum



  }

  def part2(input: Seq[String]): Long = {
    val numberIndexes = input.last.zipWithIndex.filter(pred => pred._1 == '*' || pred._1 == '+').map(_._2)
    val lineLength = input.head.length
    (0 until lineLength)
      .reverse
      .foldLeft((List[Problem](), List[Long]()))((acc, i) => {
        val numberOpt = input.slice(0, input.size-1).map(s => s(i)).mkString.trim.toIntOption
        numberOpt match {
          case Some(number) if numberIndexes.contains(i) => (acc._1 :+ Problem(acc._2 :+ number, input.last(i).toString), List())
          case Some(number) =>  (acc._1, acc._2 :+ number)
          case None => acc
        }
      })._1.map(_.result()).tapEach(println).sum
  }
}
