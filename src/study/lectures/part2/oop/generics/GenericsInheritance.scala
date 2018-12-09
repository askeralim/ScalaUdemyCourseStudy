package study.lectures.part2.oop.generics

object GenericsInheritance {
  val catList = new TestList[Cat]
  catList.add(new Dog)

}

class Animal
class Cat extends  Animal
class Dog extends Animal

class TestList[+A] {
  //def add(element:A)=new TestList[A] -- ERROR here because of the Covariance issue. Need to rewrite as follows.
  def add[B >: A](element: B) = new TestList[B]
}