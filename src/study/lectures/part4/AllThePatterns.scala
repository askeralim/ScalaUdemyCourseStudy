package study.lectures.part4

object AllThePatterns extends App {
  val x: Any = "Scala"
  // Scala Pattern Matches with any data types.
  val constants = x match {
    case 1 => "A Number"
    case true => "A Boolean Value"
    case "Scala" => "String Value"
    case AllThePatterns => "A Singleton Object"
  }
  // All Matching
  val matchAnything = x match {
    case _ =>
  }
  println(matchAnything) // Prints a Touple

  val matchVariable = x match {
    case something => s"Some Variable Val $something $x"
  }
  println(matchVariable)

  val aTuple = (1,2)
  val matchTuple = aTuple match {
    case (1,1) => "Value is (1,1)"
    case (something,2) => s"I got the value $something with 2"
  }
  print(matchTuple)
  //Nested Tuples - Showing error
  val nestedTuple = (1,(1,2))
  def matchNestedTuple(nestedTuple: (Int,Any)):String = nestedTuple match{
    case (_,(2,v)) => s"I got a tuple with 2 in second tuple $v"
  }
  println(matchNestedTuple(nestedTuple))

  def f(x: (Int, Any)): Unit = {
    val y = x match {
      case (1, 1) => println("the only ones")
      //variable pattern in the tuple
      case (v, 1) => println(v + " is paired with 1")
      //deep match with wildcards and a variable
      case (_, (v, 5)) => println("deep tuple with " + v + " and 5 in the nested pair ")
      case _ => println("default case")
    }
  }

  f(1,(1,5))        //> the only ones
}
