package study.lectures.part2.oop

object OOBasic extends App {
  val person1 = new Person1
  println(person1)
  val person2 = new Person2("Asker", 36)
  println(person2.age)

  val person = new Person("Asker", 36)
  //print(person.name)// Error here Because the fields are not the Class Fields.

  val person3 = new Person3("Asker", 45)
  person3.greet("Haris")
  person3.greet()

}
//Simple Class
class Person1 //Class Parameters are "NOT FIELDS"
//Class with One Constructor
class Person(name:String, age:Int) // Here the NAME and AGE are not the fields, these are the parameter variables here.
//Class with one Constructor and Class Fields Name, Age
class Person2(val name:String, val age:Int)

//Class with Method overloading , this
class Person3(name:String, age:Int=0){
  def greet(name:String) =
    println(s"Hi ${this.name} called $name")
  //Overloading
  def greet() =  println(s"Hi ${this.name} called NONE")
  def this(name:String) = this(name,0)//By providing default value 0 to age will fix the value age issue.
}

