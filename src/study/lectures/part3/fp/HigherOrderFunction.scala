package study.lectures.part3.fp

object HigherOrderFunction extends App{
  def nTimes(f:Int=>Int, n:Int, x:Int):Int = {
    if(n<=0) x
    else x*nTimes(f,n-1, f(x))
  }

  println(nTimes(x=>x+1, 3, 1))

  //1*nTimes(f,3,1)
  //  1*nTimes(f,2,2)       1*24  = 24
  //    2*nTimes(f,1,3)     2*12  = 24
  //      3*nTimes(f,0,4)   12    = 12

  def nTimesBetter(f:Int=>Int, n:Int):(Int=>Int) =
    if(n<=0) (x:Int)=>x
    else (x:Int) => x*nTimesBetter(f,n-1)(f(x))

  val calculator = nTimesBetter(x=>x+1, 3)
  println(calculator(1))

  def toCurry(f:(Int, Int)=>Int) :(Int=>Int=>Int) = x=>y=>f(x,y)
  def fromCurry(f:(Int=>Int=>Int)) :(Int, Int)=>Int = (x,y)=>f(x)(y)

  def compose[T,B,A](f:T=>B, g:A=>T):A=>B = x=>f(g(x))
  def andThen[A,T,B](f:A=>T, g:T=>B):A=>B = x=>g(f(x))

  //Examples
  def superAdder2:(Int=>Int=>Int) = toCurry(_+_)
  def adder4 = superAdder2(4)
  println(adder4(17)) // It prints 4+17 = 21
  //Super Adder without Curry
  def superAdderWOCurry:(Int=>Int=>Int) = x=>y=>x+y
  def adder4WOCurry = superAdderWOCurry(4)
  println(adder4WOCurry(17))

  def add3 :Int =>Int = x=>x+3
  def times4 :Int =>Int = x=>x*3

  def composed = compose(add3, times4)
  def ordered = andThen(add3, times4)
  println(composed(4)) // 15
  println(ordered(4)) // 21

}
