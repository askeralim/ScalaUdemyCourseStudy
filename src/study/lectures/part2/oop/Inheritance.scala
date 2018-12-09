package study.lectures.part2.oop

object Inheritance extends App {

  class Person(name:String, age:Int){
    protected val myType = "Person"
    def this(name:String) = this(name, 0)
    private val myOwnField = "For me only"
    def getMyOwnField = myOwnField// Public getter for private field
  }
  class Adult(name:String, age:Int, regNo:String, override protected val myType: String) extends Person(name, age)//Override two ways one here as constructor
  class Child(name:String, age:Int, regNo:String) extends Person(name){
    override protected val myType: String = "Child" // Second way of overriding.
  }

  class Animal{
    private val myType="Animal"
    val creatureType="Wild"
    protected def eat =println("Animal None..")
  }
  class Cat extends Animal{
    private val myType="Cat"// You cannot override because it is a private field
    override val creatureType="Domestic"
    override  def eat = print("Cat Eats")
  }

  val cat = new Cat
  cat.eat
  println(cat.creatureType)
}
