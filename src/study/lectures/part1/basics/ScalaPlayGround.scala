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

  val someValue: Option[String] = Some("I am wrapped in something")
  println(someValue)

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }
  val value1 = maybeItWillReturnSomething(true)
  val value2 = maybeItWillReturnSomething(false)


  println( value1 getOrElse "No value")
  println( value2 getOrElse "No value")
  println(value2 getOrElse {
    "default function"
  })

  val number: Option[Int] = Some(3)
  val noNumber: Option[Int] = None
  val result1 = number.map(_ * 1.5)
  println(result1)
  val result2 = noNumber.map(_ * 1.5)
  println(result2)

  val number1: Option[Int] = Some(3)
  val noNumber1: Option[Int] = None
  val result21 = number1.fold(1)(_ * 3)
  val result22 = noNumber1.fold(1)(_ * 3)
  println(result21)
  println(result22)

}
