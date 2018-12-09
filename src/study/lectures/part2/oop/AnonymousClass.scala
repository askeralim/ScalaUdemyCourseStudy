package study.lectures.part2.oop

object AnonymousClass extends  App {
  val p = new APerson("Asker")
  println(p)
  val p1 = new APerson("Haris"){
    override def toString: String = s"I am brother & Name is P1"
  }
  println(p1)
}

class APerson(name:String){
  override def toString: String = s"My Name is $name"
}