package study.lectures.part1.basics

object ScalaPlayGround extends App {
  val list = List(1 to 10, 3 to 12)
  println(list)
  for (d <- list(0))
    println("Item in List :" + d)
  val myMap = Map("Asker" -> "Spark")
  //println(myMap("Haris")) //Throws Error
  //To Resolve this
  println(util.Try(myMap("Haris")) getOrElse "Not Available") //Throws Error
}
