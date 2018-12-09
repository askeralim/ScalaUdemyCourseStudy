package study.lectures.part2.oop.generics

object GenericListExample extends App{
  val list = GenericEmptyList
  val list1 = list.add(new Cat)
  val list2 = list.add(new Cat).add(new Dog)
  println(list1)

}
class Animal
class Cat extends  Animal
class Dog extends Animal

// My Tests

abstract class GenericListBase[+A]{
  def head:A
  def tail:GenericListBase[A]
  def isEmpty:Boolean
  def add[B>:A](item:B):GenericListBase[B]
  def printElements:String
  override def toString ="["+printElements+"]"
}
object GenericEmptyList extends GenericListBase[Nothing]{
  def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException
  override def tail: GenericListBase[Nothing] = throw new NoSuchElementException
  override def add[B>:Nothing](item: B): GenericList[B] = new GenericList[B](item, GenericEmptyList)
  override def printElements:String = ""
}
class GenericList[+A](item:A, tailList:GenericListBase[A]) extends GenericListBase[A]{
  override def isEmpty = false
  override def head: A = item
  override def tail: GenericListBase[A] = tailList
  override def add[B>:A](item: B): GenericList[B] = new GenericList[B](item, this)
  override def printElements: String = if(!tailList.isEmpty)  tail.printElements + " " + item
  else  ""+item
}