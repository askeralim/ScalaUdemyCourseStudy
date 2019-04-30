package study.concurrency

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureExample extends App {
  println("Outside Future")
  var f= Future {
    print("Inside Future")
  }
  println(readLine())
}
