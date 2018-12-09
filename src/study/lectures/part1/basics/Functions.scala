package study.lectures.part1.basics

object Functions extends  App {
  def multiply(a:Int, b:Int):Int = a*b
//  print(multiply(3,2))
  def greet(name:String, age:Int) = "Hi My name is "+name+" and I am "+age+" years Old"
  def factorial(n:Int):Int = {
    if(n== 1) 1 else n* factorial(n-1)
  }
  def isPrime(n:Int)=n%2
  def fib(n:Int):Int={
    if(n==1 || n==2) n
    else fib(n-1)+ fib(n-2)
  }
  println(greet("Asker",25))
  println(factorial(5))
  println(fib(5))
}
