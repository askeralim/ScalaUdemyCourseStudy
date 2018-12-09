package study.lectures.part2.oop

object MethodNotation extends App{
  class Person(name:String, age:Int=0){
    def +(ch:String) = new Person(this.name + ch)
    def print=println(name+" Age:"+age)
    def unary_+ = new Person(this.name, this.age+1)
    def learns(lan:String) :Person= new Person(this.name + " learns "+ lan)
    def learnsScala():Person = this learns "Scala"
    def apply(age:Int) = new Person(this.name, age)
  }
  val marry = new Person("Mary")
  val rockMary = marry + "The rock Star"
  rockMary.print
  val nextAge = +marry
  nextAge.print
  val maryScala = marry learns "Scala"
  maryScala.print
  val maryLearnsScala = marry learnsScala

  maryLearnsScala.print
  val newAge = maryScala(23)
  newAge.print
}
