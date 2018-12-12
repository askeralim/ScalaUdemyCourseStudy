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
}
