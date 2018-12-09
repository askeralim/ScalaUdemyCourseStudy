package study.lectures.part2.oop

class CPerson(name:String){
  override def toString: String = s"My Name is $name"
}
abstract class APerson(name:String){
  override def toString: String = s"My Name is $name"
}

object AnonymousClass extends  App {
  val p = new CPerson("Asker")
  println(p)
  val p1 = new APerson("Haris") {
    override def toString: String = s"I am brother & Name is P1"
  }
  println(p1)

  // Trait Execution
  val animal = new AAnimal {
    override def eat: Unit = println("Let me eat");
  }
}


// Traits Instantiation

trait AAnimal{
  def eat :Unit;
}