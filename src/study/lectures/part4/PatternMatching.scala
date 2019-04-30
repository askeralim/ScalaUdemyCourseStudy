package study.lectures.part4

import study.lectures.part2.oop.CaseClasses.Person

import scala.util.Random

object PatternMatching extends App {
  println("Hello Pattern Matching")
  val random = new Random
  val myVal = random.nextInt(10)
  val description = myVal match {
    case 0 => "Number Zero"
    case 1 => "Number 1"
    case 2 => "Number 2"
    case 3 => "Number 3"
    case _ => "Number Other"
  }
  println(description)

  //class Person(name:String, age:Int)
  val bob = new Person("Asker", 34)
  val greet = bob match {
    case Person(name, age) => s"I am a Person Name: $name and age: $age"
    case Person(name, age) if (age > 25) => s"I am a Person Name: $name and age: $age Less than 25"
    case _ => "I am not a person"
  }
  println(greet)

  /**
    * 1. The first match will be considered
    * 2. If there is no match it will print scala.MatchError
    * 3. The return type will unify the return type.
    * 4. It can Match the InstanceType of the class can be considered.
    * 5. Pattern Matching works really well with Sealed Classes
    */


  /**
    * Pattern Matching with Case Classes
    */

  trait Expr

  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Product(e1: Expr, e2: Expr) extends Expr
  val expr: Expr = Product(Sum(Number(1), Number(2)), Number(3))

  def show(e: Expr): String = e match {
    case Sum(n1, n2) => show(n1) + " + " + show(n2)
    case Number(n)   => s"$n"
    case Product(n1, n2) => {
      def displayBracket(ex: Expr) = ex match {
        case Product(_,_) => show(ex)
        case Number(_) => show(ex)
        case _ => "("+show(ex)+")"
      }
      displayBracket(n1) +" * " + displayBracket(n2)
    }
  }
  println (show (expr) )
}
