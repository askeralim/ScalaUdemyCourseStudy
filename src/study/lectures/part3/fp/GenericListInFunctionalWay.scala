package study.lectures.part3.fp

import study.lectures.part2.oop.generics.EmptyList.{head, tail}

object GenericListInFunctionalWay extends App{
val list = EmptyList.add(1).add(2).add(3);
  val list1 = EmptyList.add(1).add(2).add(3)
  println(list)
  println("Even Number :"+list.filter((item:Int)=>item%2 == 0))
  println("10 Times Number :"+list.map((item:Int)=>item*10))
  println("Joined  :"+(list ++ list1.map((item:Int)=>item*2)))
  println("Flat map :"+list.flatMap((item:Int) => new AdvancedList(item, new AdvancedList(item+1, EmptyList))))
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

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list;
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
}