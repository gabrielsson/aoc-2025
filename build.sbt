name := "aoc-2025"

version := "0.1.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
  "com.google.guava" % "guava" % "32.1.3-jre",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
  "org.scalatest" %% "scalatest" % "3.3.0-SNAP4" % Test,
  "org.scalatestplus" %% "junit-4-13" % "3.3.0.0-SNAP3" % Test,
  "junit" % "junit" % "4.13.2" % Test,
  "org.scala-lang.modules" %% "scala-xml" % "2.2.0" % Test
)
