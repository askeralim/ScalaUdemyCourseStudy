package study.exercises.problems

import scala.annotation.tailrec

/**
  *   Refer : http://aperiodic.net/phil/scala/s-99/ for Questions.
  */
object Part1_99Problems extends App {
  //P01
  last(List(1,2,3,4,5,6,7,8))
  print(last(List(1,2,3,4,5,6,7,8))) // or can be called as List(1,2,3,4,5,6,7,8).last internal Csla Function

  //P02
  secondLast(List(1,2,3,4,5,6,7,8))

  //P03 nth Element
  nthElement(2,List(1,2,3,4,5,6,7,8))

  //P04 nth Element
  count(List(1,2,3,4,5,6,7,8))
  //println("Count : "+count(List(1,2,3,4,5,6,7,8)))

  //P05
  reverseFunctional(List(1,2,3,4,5,6,7,8))
  println("Reverse : "+reverseFunctional(List(1,2,3,4,5,6,7,8)) +"\n"+reverse(List(1,2,3,4,5,6,7,8)))

  //P07
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))

  //P01
  /**
    * @param ls   A List is represented like 1 :: 2 :: 3 :: Nil  => Implied a List(1,2,3)
    * @tparam A The List of Type A
    */
  def last[A](ls:List[A]):A = ls match{
    case h :: Nil  => h // Here Head is the lst element
    case _ :: tail => last(tail)
    case _         => throw new NoSuchElementException
  }
  //P02
  def secondLast[A](ls:List[A]):A = ls match{
    case h :: nxt :: Nil  => h
    case h :: tail        => secondLast(tail)
    case _                => throw new NoSuchElementException
  }
  //P03
  def nthElement[A](n: Int, ls: List[A]):A = (n,ls) match{
    case (0, h :: _) => h
    case (n, h :: tail) => nthElement(n-1, tail)
    case _ => throw new NoSuchElementException
  }
  //P04
  def count(ls:List[Int]):Int = {
    @tailrec
    def countWithAccumulator(count:Int, list: List[Int]): Int = {
      list match {
        case Nil => count
        case x :: xs => countWithAccumulator(count+1, xs)
      }
    }
    countWithAccumulator(0, ls)
  }
  //P04 with recursion solution
  def countRecursive[A](ls: List[A]): Int = ls match {
    case Nil       => 0
    case _ :: tail => 1 + countRecursive(tail)
  }
  // P04 More pure functional solution, with folds.
  def countFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

  def reverse[A](ls:List[A]):List[A] = {
    @tailrec
    def reverseR(rl:List[A], list: List[A]):List[A] = list match {
        case Nil => rl
        case h :: tail => reverseR(h::rl, tail)
      }
    reverseR(Nil, ls)
  }
  // P05 More pure functional solution, with folds.
  def reverseFunctional[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) { (rl, c) => c :: rl }
  /**
    * Tail recursion implementation
    * @param ls
    * @return
    */
  def sum(ls:List[Int]):Int = {
    @tailrec
    def sumWithAccumulator(list: List[Int], accumulator: Int): Int = {
      list match {
        case Nil => accumulator
        case x :: xs => sumWithAccumulator(xs, accumulator + x)
      }
    }
    sumWithAccumulator(ls, 0)
  }


  //P07
  def flatten(ls:List[Any]):List[Any] = ls flatMap{
    case ms:List[Any] => flatten(ms)
    case e =>List(e)
  }
}



