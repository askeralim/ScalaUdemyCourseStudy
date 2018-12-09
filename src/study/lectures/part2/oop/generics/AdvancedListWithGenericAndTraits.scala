package study.lectures.part2.oop.generics

import study.lectures.part2.oop.generics.EmptyList.{head, tail}

object AdvancedListWithGenericAndTraits extends App{
val list = EmptyList.add(1).add(2).add(3);
  val list1 = EmptyList.add(1).add(2).add(3);

  println(list)
  val predicate = new Predicate[Int]() {
    override def test(item:Int) = item%2 == 0
  }
  val transformer = new Transformer[Int, Int] {
    override def transform(element: Int): Int = element *10;
  }
  println("Even Number :"+list.filter(predicate));
  println("10 Times Number :"+list.map(transformer));
  println("Joined  :"+(list ++ list1.map(transformer)));
}
trait Predicate[-T]{
  def test(element:T):Boolean
}
trait Transformer[-A,B]{
  def transform(element:A):B
}
abstract class MyList[+A]{
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean
  def add[B>:A](item:B):MyList[B]
  def printElements:String
  override def toString ="["+printElements+"]"

  def map[B](transformer: Transformer[A,B]):MyList[B]
  def flatMap[B](transformer: Transformer[A,MyList[B]]):MyList[B]
  def filter(predicate: Predicate[A]):MyList[A]
  def ++[B>:A](list:MyList[B]):MyList[B]
}

object EmptyList extends MyList[Nothing]{
  def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def add[B>:Nothing](item: B): MyList[B] = new AdvancedList[B](item, EmptyList)
  override def printElements:String = ""
  override def map[B](transformer: Transformer[Nothing, B]): MyList[B] = EmptyList
  override def flatMap[B](transformer: Transformer[Nothing,MyList[B]]):MyList[B] = EmptyList
  override def filter(predicate: Predicate[Nothing]):MyList[Nothing] = EmptyList

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list;
}

class AdvancedList[+A](item:A, tailList:MyList[A]) extends MyList[A]{
  override def isEmpty = false
  override def head: A = item
  override def tail: MyList[A] = tailList
  override def add[B>:A](item: B): AdvancedList[B] = new AdvancedList[B](item, this)
  override def printElements: String = if(!tailList.isEmpty)  tail.printElements + " " + item
  else  ""+item

  override def filter(predicate: Predicate[A]): MyList[A] =
    if(predicate.test(head)) new AdvancedList(head, tail.filter(predicate))
    else tail.filter(predicate)

  override def map[B](transformer: Transformer[A, B]): MyList[B] = new AdvancedList(transformer.transform(head), tail.map(transformer))

  override def flatMap[B](transformer: Transformer[A, MyList[B]]): MyList[B] = ???

  override def ++[B >: A](list: MyList[B]): MyList[B] = new AdvancedList(head, tail ++ list);
}