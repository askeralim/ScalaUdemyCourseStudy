package study.exercises

object BookAuthorExample extends App {
println(new Writer("Asker", "Ali",32).name)
  new Counter(10).inc().print
}
class Writer(firstName:String, lastName:String, val year:Int){
  def name = firstName+lastName
}
class Book(name:String, author:Writer, releaseYear:Int ){
  def authorAge =releaseYear - author.year
  def isWrittenBy(auth:Writer) = auth == author
}
class Counter(val count:Int){
  def inc(size:Int=1)=new Counter(count+size)
  def dec(size:Int=1)=new Counter(count-size)
  def print = println(s"Couner Value $count")
}