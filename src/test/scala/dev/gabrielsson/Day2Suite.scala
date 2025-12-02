package dev.gabrielsson

import org.junit.runner.RunWith
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Day2Suite extends AnyFlatSpec with Matchers {
  val day = new Day2

  it should "part1Test" in {
    day.part1(day.getTestRaw) shouldBe 1227775554
  }
  it should "part1" in {
    day.part1(day.getRaw) shouldBe -1
  }
  it should "part2Test" in {
    day.part2(day.getTestRaw) shouldBe "4174379265"
  }
  it should "part2" in {
    day.part2(day.getRaw) shouldBe "70187097315"
  }

  it should "part2 small" in {
    //day.part2("2121212118-2121212124") shouldBe "2121212121"
    day.part2("824824823-824824824") shouldBe "824824824"

  }
}
