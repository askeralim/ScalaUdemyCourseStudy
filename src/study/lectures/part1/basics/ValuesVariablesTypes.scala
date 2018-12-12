package study.lectures.part1.basics

object ValuesVariablesTypes extends App {
 val x = 42;
  println(x)
  val str ="Asker"
  val str1:String ="Asker 1"
  val char:Char ='C'
  val book:Boolean= true
  val short:Short =123
  val long:Long = 238762384623476L
  val f=122423.0f
  print(str+str1)
  print(f)
 def apply(v:Int) =  v*100
 println("Calling Apply method: "+ValuesVariablesTypes(10))
}
