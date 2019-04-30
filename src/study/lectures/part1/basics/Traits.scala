package study.lectures.part1.basics
trait  Basic{
  def myprint(){
    println("Basic")
  }
}
trait  Advanced{
  def myprint(){
    println("Advanced")
  }
}
class MyInheritance extends Basic with Advanced{
  override def myprint(){
    println("MyInheritance")
  }
}
object Traits extends App {
  val m =new MyInheritance()
  m.myprint()
}

