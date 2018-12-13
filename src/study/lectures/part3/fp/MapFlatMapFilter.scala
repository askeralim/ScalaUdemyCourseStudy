package study.lectures.part3.fp

object MapFlatMapFilter extends App{
  val list = List(1,2,3,4)
  println(list)
  //Following two are the same _ is the Syntactic Sugar to Scala
  println(list.map(_*3))
  println(list.map(x=>x*3))

  println(list.filter(_%2==0))
  println(list.filter(x=>x%2==0))

  def toQubePair(x:Int):List[Int] = List(x, x*x, x*x*x)
  println("Cube Pair :"+list.flatMap(toQubePair)) //Prints : Cube Pair :List(1, 1, 1, 2, 4, 8, 3, 9, 27, 4, 16, 64)

  val numbers = List(1,2,3,4)
  val chars = List('A','B','C','D')
  //Try to print A1, A2, A3 ...... D4

  def concat(x:Char, y:Int)= x+""+y
  def mapInt(c:Char, list:List[Int]):List[String] = list.flatMap(intVal=>List(concat(c,intVal)))
  //def mapper(x:Char):(Char,List[Int])=>List[String] = list
  println(chars.flatMap(c=>mapInt(c,numbers)))
  //Other Simple way to do it
  println(chars.flatMap(c=>numbers.map(n=> ""+c+""+n)))

  //Learning : To cross join two list use 1 flatMap and 1 Map,
  // But if there are 3, then use 2 flatMap and a Map
  //Example if Color[Black, White], if we need all combination it is as follows.
  val colors = List("Black", "White")
  println(chars.flatMap(c=>numbers.flatMap(n=>colors.map(col=> ""+c+""+n+" "+col))))
  //for Combinations
  println(for{
    n<-numbers
    col<-colors
    c<-chars  // Here the order doesnt matter
  } yield ""+c+""+n+" "+col)
  //for Combinations with Filter
  println(for{
    n<-numbers if n%2 == 0
    col<-colors
    c<-chars  // Here the order doesnt matter
  } yield ""+c+""+n+" "+col)

  for{
    n<-numbers
  } print(" "+n)

}
