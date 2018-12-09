package study.lectures.part2.oop

object IntListExample extends App{
  val list = EmptyIntList
  val list1 = list.add(1).add(2).add(3);
  print(list1)
}

abstract class IntListBase{
  def head:Int
  def tail:IntListBase
  def isEmpty:Boolean
  def add(item:Int):IntList
  def printElements:String
  override def toString ="["+printElements+"]"
}
object EmptyIntList extends IntListBase{
  def isEmpty = true

  override def head: Int = throw new NoSuchElementException
  override def tail: IntListBase = throw new NoSuchElementException
  override def add(item: Int): IntList = new IntList(item, EmptyIntList)
  override def printElements:String = ""
}
class IntList(item:Int, tailList:IntListBase) extends IntListBase{
  override def isEmpty = false

  override def head: Int = item

  override def tail: IntListBase = tailList
  override def add(item: Int): IntList = new IntList(item, this)
  override def printElements: String = if(!tailList.isEmpty)  tail.printElements + " " + item
                                       else  ""+item
}