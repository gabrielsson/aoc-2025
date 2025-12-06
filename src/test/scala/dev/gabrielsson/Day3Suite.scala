package dev.gabrielsson

import org.junit.runner.RunWith
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Day3Suite extends AnyFlatSpec with Matchers {
  val day = new Day3

  it should "part1Test" in {
    day.part1(day.getTestInput) shouldBe 357
  }

  it should "part1test small" in {
    day.findLargest("234234234234278") shouldBe ((7,13))
    day.findLargest("5115862523127395846723832323364238132364221254274483428277455233451555525274349323441333678942573392") shouldBe 1
  }
  it should "part1" in {
    day.part1(day.getInput) shouldBe -1
  }
  it should "part2Test" in {
    day.part2(day.getTestInput) shouldBe 3121910778619L
  }

  it should "part2Test small" in {
    day.part2(Seq("987654321111111")) shouldBe 987654321111L
    //day.findXLargest(1,"987654321111111", 0) shouldBe 87654321111L
  }

  it should "part2" in {
    day.part2(day.getInput) shouldBe -1
  }
}
