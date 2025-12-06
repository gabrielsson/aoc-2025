package dev.gabrielsson
import dev.gabrielsson.GridExtensions.{Grid, GridCharSeq}

class Day4 extends Inputs {

  def part1(input: String): Int = {

    val grid = input.toList.toGrid

    grid
      .filter(_._2 == '@')
      .map(_._1.surroundings)
      .map(s => s.flatMap(grid.get).count(_ == '@'))
      .count(_ < 4)

  }

  def part2(input: String): Int = {
    val grid = input.toList.toGrid



    def _collectRolls(g: Grid[Char]): Iterable[Points.Point] = {
      val extracted = extractRolls(g)

      if(extracted.isEmpty) {
        extracted
      } else {
        extracted ++ _collectRolls(g -- extracted)
      }
    }

    _collectRolls(grid).toList.length

  }

  private def extractRolls(grid: Grid[Char]) = {
    grid
      .filter(_._2 == '@')
      .filter(p => {
        p._1.surroundings.flatMap(grid.get).count(_ == '@') < 4

      }).keys

  }
}
