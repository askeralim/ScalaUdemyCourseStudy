package study.lectures.part1.basics

object CallByValueCallByName extends  App{
def callByVal(time:Long){
  println("By Val Time :"+time)
  println("By Val Time :"+time)
}
  def callByName(time: => Long){
    println("By Ref Time :"+time)
    println("By Ref Time :"+time)
  }

  callByName(System.nanoTime())
  callByVal(System.nanoTime())

  //In call by value the value will be calculated while calling the function, But when Call by Reference the value will be evaluated whenever in use.
  def infinite():Int=1+infinite()
  def printFirst(x:Int, y: => Int)= println(x)
  printFirst(32, infinite())// It will evaluate the and prints teh result,
 // printFirst( infinite(), 32)// It wont work, because it goes to Stack overflow due to calculation of the infinite method calculation rec.
}
