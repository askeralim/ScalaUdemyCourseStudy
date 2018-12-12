package study.lectures.part3.fp

object CurriedFunction extends App {
  //0. Simple COncat Function
  def concat = (val1:String, val2:String) => val1 +" "+val2
  println(concat("Asker","Ali"))
  //1. SuperAdder
  val superAdder = (x:Int) => (y:Int) => x+y  //LAMBDA Expression It is not def, It is val
  val superAdder_Similar:Int=>Int=>Int = x=> y => x+y  //LAMBDA Expression in Curried Function
  //Above two functions are same
  println(superAdder(2)(3))

  //2. String parsing
  val stringToInt =
    (x:String) => Integer.valueOf(x)

  println(stringToInt)
  println(stringToInt("12"))

  val niceAdder :(Int,Int)=>Int = _+_ // Here the underscore automatically assign to the variable sequencially
  println(niceAdder(10,12)) // Prints 12

  //3. Curried Functions
  def curriedFormatter(s:String)(x:Double):String = s.format(x)
  val standardFormat:(Double=>String) = curriedFormatter("%4.2f")
  val preciseFormat:(Double=>String) = curriedFormatter("%10.8f")

  println(standardFormat)
  println(standardFormat(Math.PI))
  println(preciseFormat)
  println(preciseFormat(Math.PI))

  //4. Curried Again - Can have multiple Parameter List
  def add10Mult(x:Int)(y:Int) =  10*x+y
  println(add10Mult(10)(20))
  def add10MultSimple:Int=>Int=>Int = x=>y=>10*x+y
  println(add10MultSimple(10)(20))
}
