package study.lectures.part2.oop

object CaseClasses extends App{
  case class Person(name:String, age:Int)
  val p = new Person("Asker", 36)
  //Feature 1:
  println(p.toString) // It will call toString(), but instead of printing object hashcode it will print the exact value : Person(Asker,36)
  val p2 = new Person("Asker", 36)
  //Feature 2:
  println("Equal :"+(p==p2)) // True eventhough both are different Objects, because it uses internal values in hashCode method.

  //Feature 3: Handy Copy method
  val p3 = p2.copy(age = 40)
  println(p3)// It will simply copy the Person Object and by updating the parameters provided.

  //Feature 4: Companion Objects -  Case class will have a default Companion Object
  val p4 = Person
  val p5 = Person("Asker",35) // It is internally calling apply method of the Person class, which is defined internally

  //Feature 5: Case classes are serializable.
  // Very helpful for using AKKA.
}

