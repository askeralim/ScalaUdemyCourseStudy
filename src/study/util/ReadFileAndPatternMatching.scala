package study.util

import scala.io.Source

object ReadFileAndPatternMatching extends App{
  val regex = "<tns:Value>[0-9]+</tns:Value>".r
  val telRegex ="[0-9]+".r
  val lines = Source.fromFile("D:\\GoogleDrive\\Nokia\\Work\\HDM\\Sprint-24\\NGN Migration\\NotFoundAll.txt").getLines()
    .flatMap(line=>
    regex.findAllIn(line).flatMap(x=>telRegex.findAllIn(x))
  )
  println(lines.mkString("','"))//foreach(println)
}
