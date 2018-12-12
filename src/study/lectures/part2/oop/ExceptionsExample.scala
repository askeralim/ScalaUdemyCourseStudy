package study.lectures.part2.oop

import java.util.{Date => UtilDate} // Aliasing a class name with new Name.
import java.io._  // Import everything
object ExceptionsExample extends App {
  val exception =  new NullPointerException
  println(exception)
  val date = new UtilDate
  println(date)
}
