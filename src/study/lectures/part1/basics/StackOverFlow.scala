package study.lectures.part1.basics

object StackOverFlow extends App{
  def factorial(n:Int)= {
    def factHelper(x:BigInt, accumulator:BigInt):BigInt = {
      //println("Calculating :"+x+" Accumulator :"+accumulator)
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //TAIL RECURSION - Last statement of the function should be recursion .
                                              // When you need loops use Tail recursion.
    }
    println("Calculating Factorial:"+n)
    factHelper(n,1)
  }
  print("Factorial :"+factorial(100))
}
