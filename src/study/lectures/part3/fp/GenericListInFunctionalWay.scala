package study.lectures.part3.fp

import javafx.collections.transformation.SortedList
import study.lectures.part2.oop.generics.EmptyList.{head, tail}

object GenericListInFunctionalWay extends App{
val list = EmptyList.add(1).add(2).add(3);
  val list1 = EmptyList.add(2).add(4).add(6)
  println(list)
  println("Even Number :"+list.filter((item:Int)=>item%2 == 0))
  println("10 Times Number :"+list.map((item:Int)=>item*10))
  println("Joined  :"+(list ++ list1.map((item:Int)=>item*2)))
  println("Flat map :"+list.flatMap((item:Int) => new AdvancedList(item, new AdvancedList(item+1, EmptyList))))
  list1.forEach(x=>print(" - "+x))
  println("\nSorted List :"+list.sort((x,y)=>x-y))
  println("\nZipped List :"+list.zipWith(list1,(x:Int,y:Int)=>x+y))
  println("\nFold List :"+list.fold(0)((x:Int, y:Int)=>x+10*y))
}
abstract class MyList[+A]{
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean
  def add[B>:A](item:B):MyList[B]
  def printElements:String
  override def toString ="["+printElements+"]"
  // Higher Order Functions - Accepts or returns Functions
  def map[B](transformer: A=>B):MyList[B]
  def flatMap[B](transformer: A=>MyList[B]):MyList[B]
  def filter(predicate: A=>Boolean):MyList[A]
  def ++[B>:A](list:MyList[B]):MyList[B]

  def forEach(f:A=>Unit):Unit
  def sort(compare:(A,A)=>Int):MyList[A]
  def zipWith[B,C](list:MyList[B], zip:(A,B)=>C):MyList[C]
  def fold[B](startVal:B)(operator: (B, A)=>B):B

}

object EmptyList extends MyList[Nothing]{
  def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def add[B>:Nothing](item: B): MyList[B] = new AdvancedList[B](item, EmptyList)
  override def printElements:String = ""
  override def map[B](transformer: Nothing => B): MyList[B] = EmptyList
  override def flatMap[B](transformer: Nothing=>MyList[B]):MyList[B] = EmptyList
  override def filter(predicate: Nothing=>Boolean):MyList[Nothing] = EmptyList

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def forEach(f: Nothing => Unit): Unit = () // Opening and closing will make Unit
  override def sort(compare: (Nothing,Nothing) => Int): MyList[Nothing] = EmptyList
  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = EmptyList
  override def fold[B](startVal: B)(operator: (B, Nothing) => B): B = startVal
}

class AdvancedList[+A](item:A, tailList:MyList[A]) extends MyList[A]{
  override def isEmpty = false
  override def head: A = item
  override def tail: MyList[A] = tailList
  override def add[B>:A](item: B): AdvancedList[B] = new AdvancedList[B](item, this)
  override def printElements: String = if(!tailList.isEmpty)  tail.printElements + " " + item
  else  ""+item

  override def filter(predicate: A =>Boolean): MyList[A] =
    if(predicate(head)) new AdvancedList(head, tail.filter(predicate))
    else tail.filter(predicate)
  override def map[B](transformer: A=> B): MyList[B] = new AdvancedList(transformer(head), tail.map(transformer))
  override def flatMap[B](transformer: A=> MyList[B]): MyList[B] = transformer(head) ++ tail.flatMap(transformer)
  override def ++[B >: A](list: MyList[B]): MyList[B] = new AdvancedList(head, tail ++ list)

  override def forEach(f: A => Unit): Unit = {
    f(head)
    tailList.forEach(f)
  }
  override def sort(compare: (A,A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]):MyList[A] = {
      if (sortedList.isEmpty) new AdvancedList[A](x, EmptyList)
      else if (compare(x, sortedList.head) <= 0) new AdvancedList[A](x, insert(sortedList.head, sortedList.tail))
      else new AdvancedList[A](sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = tail.sort(compare);
    insert(head, sortedTail)
  }
  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = new AdvancedList[C](zip(head,list.head), tail.zipWith(list.tail, zip))

  override def fold[B](startVal: B)(operator: (B, A) => B): B = {
    val newStartVal = operator(startVal, head)
    tail.fold(newStartVal)(operator)
  }
}