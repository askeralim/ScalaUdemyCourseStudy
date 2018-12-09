package study.lectures.part2.oop

object CompanionDesign extends App {
  object Person{
    val TYPE="PERSON"
  }
  class Person(val name:String)
  val p = new Person("Asker")
  print(Person.TYPE +" "+ p.name)
}
