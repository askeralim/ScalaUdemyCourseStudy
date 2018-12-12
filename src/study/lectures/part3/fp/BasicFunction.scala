package study.lectures.part3.fp

object BasicFunction extends App{
  def adder = (a:Int,b:Int)=> a+b
  println(adder(1,2))
  def perform(val1:Int, val2:Int, action:(Int,Int)=>Int) = action(val1, val2)
  println(perform(1,2, adder))

}
