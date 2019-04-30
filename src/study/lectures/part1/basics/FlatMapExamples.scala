package study.lectures.part1.basics

object FlatMapExamples extends App{
  val s = List(1,200,301,4)
  println(s.flatMap(s=>s"$s"))
  println(s.flatten(_.toString))
  println(s.map(s=>s"$s.00")) // Converting to String
  println(s.map(s=>s*10)) // Multiplying
  println(s.map(s=>s*10).sum)

  val cList = List(1,2,List(3,4,List(5,6)),List(7,List(8)))
  def recFlatten[A](ls:List[A]):List[A] = ls flatten {
    case l:List[A] => recFlatten(l)
    case e => List(e)
  }
  println(cList.flatten(_.toString))
  println(recFlatten(cList))
}
