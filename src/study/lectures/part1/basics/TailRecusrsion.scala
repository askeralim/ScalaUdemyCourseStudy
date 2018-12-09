package study.lectures.part1.basics

import scala.annotation.tailrec

object TailRecusrsion extends App{

  def factorial(n:Int)= {
    @tailrec
    def factHelper(x:BigInt, accumulator:BigInt):BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    println("Calculating Factorial:"+n)
    factHelper(n,1)
  }

  def concat(s:String, n:Int):String = {
    @tailrec
    def concatHelper(x:String, n:Int, accum:String):String = {
      println("Cocat :"+n+" "+accum)
      if (n <= 0) accum
      else concatHelper(x, n - 1, x + accum)
    }
    println("Calculating ")
    concatHelper(s, n, "")
  }
  def fibenacci(n:Int):Int = {
    @tailrec
    def fibHelper(i:Int, succ1:Int, succ2:Int) :Int=
      if(i>=n ) succ1
      else {
        println("Calculating fib("+(i+1)+","+succ1+","+succ2+")")
        fibHelper(i+1,   succ1+succ2, succ1)
      }
   if(n<=2) 1
   else fibHelper(2,1,1)
  }
  //print("Factorial Result:"+factorial(100))
  //println("Result :"+concat("Asker ",5))
  println(fibenacci(8))
}
