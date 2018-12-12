package study.lectures.part3.fp

object CurriedFunction extends App {
  def concat = (val1:String, val2:String) => val1 +" "+val2
  println(concat("Asker","Ali"))

  val superAdder = (x:Int) => (y:Int) => x+y  //LAMBDA Expression It is not def, It is val
  val superAdder_Similar:Int=>Int=>Int = x=> y => x+y  //LAMBDA Expression in Curried Function
  //Above two functions are same
  println(superAdder(2)(3))

  val stringToInt =
    (x:String) => Integer.valueOf(x)

  println(stringToInt)
  println(stringToInt("12"))

  val niceAdder :(Int,Int)=>Int = _+_ // Here the underscore automatically assign to the variable sequencially
  println(niceAdder(10,12)) // Prints 12
}
