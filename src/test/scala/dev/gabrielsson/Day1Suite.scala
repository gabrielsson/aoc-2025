package dev.gabrielsson

import org.junit.runner.RunWith
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Day1Suite extends AnyFlatSpec with Matchers {
  val day = new Day1

  it should "modulo" in {
    -5 / 100 shouldBe 0

    (50-68) % 100 shouldBe -18

  }

  it should "part1Test" in {
    day.part1(day.getTestInput) shouldBe 3
  }
  it should "part1" in {
    day.part1(day.getInput) shouldBe 1
  }
  it should "part2Test" in {
    day.part2(day.getTestInput) shouldBe 1
  }
  it should "part2" in {
    day.part2(day.getInput) shouldBe >(2185)
    day.part2(day.getInput) shouldBe 1

  }

  it should "part2 small" in {
    day.part2(Seq("R1000")) shouldBe 10
  }
}
