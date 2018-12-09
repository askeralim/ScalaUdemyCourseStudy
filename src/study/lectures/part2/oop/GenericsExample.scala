package study.lectures.part2.oop

import scala.reflect.ClassTag

object GenericsExample extends App{
  //val list = new MyList()
  //  val list1 = list.add(new Item(12))
  //  val list2 = list1.add(new Item(13))
  //  println(list)
  //  println(list1)
  //  println(list2)
  //
  //  val catList = new TestList[Cat]
  //  catList.add(new Dog)

}
//class Animal
//class Cat extends  Animal
//class Dog extends Animal
//
//class TestList[+A] {
//  //def add(element:A)=new TestList[A] -- ERROR here because of the Covariance issue. Need to rewrite as follows.
//  def add[B >: A](element: B) = new TestList[B]
//}

//class Item(val value:Any, val next:MyList = null){
//  //var next:MyList = null;
//  def isNextAvailable :Boolean= next!=null
// // def next() :MyList = next
//  def next(next:MyList) = new Item(value, next)
//  override def toString : String = value.toString
//}
/*abstract class ListBase[+A]{
  abstract def isEmpty:Boolean
  abstract def add[B>:A](item:B):MyList[B]
  abstract def print
  override def toString ="["+print+"]"
}


object EmptyList[A] {
def isEmpty = true
def toString = ""

//override def add[B>:A](item: A): MyList[B] = new MyList[B](item, new EmptyList[B])
//override def add(item:A): MyList[A] = new MyList[A](item, null)
}
class MyList[+A](head:A, tail:ListBase[A]) extends ListBase[A]{
  override def isEmpty = false
  override def toString: String = tail.toString +" "+head

  override def add[B >: A](item: B): MyList[B] = new MyList[B](item, this)

  override def print: Unit = head.toString + tail.print
}

*/
