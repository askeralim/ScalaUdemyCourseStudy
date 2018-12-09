package study.lectures.part1.basics

object Expressions extends App {
  val x=1+2 //Expressions
  println(x)
  println(2+3*4)
  //+ - * / & | << >> >>>(Right shift with 0 prefix)
  println(1==x) //Equals Expressions
  // == != > >= < <= !=

//  Instruction(Do Something) Vs Expression(Compute a Value)
  val condition = true
  val result = if(condition) 5 else 4 // Different from Java
                                      // if(condition) result = 5 ; else result = 4;

  //Unit While is a Unit
 // val aUnitValue = (var test =3)
 // print (aUnitValue)
  val s = {
   2<3
 }
  println(s)
  val so={
    if(s) 2 else 3
    42
  }
  println(so)
  println( println(so))
}
