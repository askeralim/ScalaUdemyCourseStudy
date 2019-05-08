package study.exercises.problems

import scala.annotation.tailrec

/**
  *   Refer : http://aperiodic.net/phil/scala/s-99/ for Questions.
  */
object Part01_99Problems extends App {
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

  // P06
  isPalindrome(123456654)
  println("IS Palindrome :"+isPalindrome(1234454321))
  println("IS Palindrome :"+isPalindrome(List(1,2,3,4,3,2,1)))
  println("IS Palindrome :"+isPalindrome("ABCDCBA"))

  //P07
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))

  //P08 Eleminate Consecutive repetition in a List
  println("Compress :"+distinct(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  //P09 Split group of similar Items into a seperate Lists
  println("Pack :"+pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  //P10 Split group of similar Items into a seperate Lists
  println("Pack :"+packCount(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  //P11 Split group of similar Items into a seperate Lists if count 1 no Tuples
  println("Pack :"+packCountEncode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  //P12 Decode the List to the exact List
  println("Decode :"+decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))

  //P14 P15
  println("Duplicate List :"+duplicateN(3, List('a, 'b, 'c, 'c, 'd)))

  //P16
  println("Drop every nth List :"+drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  //P17
  split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //Result : res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  //P18
  slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  //res0: List[Symbol] = List('d, 'e, 'f, 'g)

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

    //P05
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

  //P06
  def isPalindrome[A](item:A):Boolean = item match {
    case head :: Nil => isPalindrome(head)
    case ls:List[A] => ls.head == ls.last &&  isPalindrome(ls.drop(1).dropRight(1))
    case ls:String => ls.reverse == ls
    case e => e.toString.reverse == e.toString
  }

  //P07
  def flatten(ls:List[Any]):List[Any] = ls flatMap{
    case ms:List[Any] => flatten(ms)
    case e =>List(e)
  }

  //P08
  def distinct[A](ls:List[A]):List[A] = {
    @tailrec
    def compressWithAccumulator(last:A, list: List[A], compressedList: List[A]): List[A] = {
      list match {
        case Nil => compressedList
        case h :: tail => compressWithAccumulator(h,tail, if(last == h)  compressedList else compressedList :+ h) // Appending the Head at the end
      }
    }
    compressWithAccumulator(ls.head, ls.tail, List(ls.head))
  }
  def distinctFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }
  //P09
  def pack[A](ls:List[A]):List[List[A]] = {
    if(ls.isEmpty) List(List())
    val (packed, next) = ls span {_ == ls.head} // Refer span method with split the array based on condition till it fails from initial
    if(next == Nil) List(packed)
    else packed :: pack(next)
  }

  //P10
  def packCount[A](ls:List[A]):List[(Int,A)] = {
    if(ls.isEmpty) List(List())
    val (packed, next) = ls span {_ == ls.head} // Refer span method with split the array based on condition till it fails from initial
    if(next == Nil) List((packed.length, packed.head))
    else (packed.length,packed.head) :: packCount(next)
  }
  //P10 By reusing the pack function above
  def packCountRefer[A](ls:List[A]):List[(Int,A)] = pack(ls) map(s=>(s.length,s.head))

  //  P11
  //  scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  def packCountEncode[A](ls:List[A]):List[Any] = pack(ls) map(s => s.length match{
    case 1 => s.head
    case _ => (s.length,s.head)
  })

  //P11 By Refering 11
  def packCountEncode2[A](ls:List[A]):List[Any] = packCountRefer(ls) map(s => if(s._1==1) s._2 else s)

  //P12 Decode
  //  scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  //  res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  def decode[A](ls:List[(Int,A)]):List[A] = ls flatMap(s=>List.fill(s._1)(s._2))

  //P13 P14 Fill List
  //  scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  //  res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  def duplicateN[A](count:Int,ls:List[A]):List[A] = ls flatMap(s=>List.fill(count)(s))

  //P16
 // def drop[A](size:Int, ls:List[A]):List[A] = ls grouped(size) map(subList=> subList (List())).collect//((ls:List[A],item)=> ls :: item)) //flatMap(item=>List(item))
  def drop[A](size:Int, ls:List[A]):List[A] = ls.zipWithIndex.collect{
        case (x, i) if((i+1)%size !=0) => x
      }
  def drop_ForComprehension[A](size:Int, ls:List[A]):List[A] = for {
    (x,i) <- ls zipWithIndex
    if i+1 % size != 0
  } yield x

  def dropFunctional[A](n: Int, ls: List[A]): List[A] =
    ls.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }

  //P17
  def split[A](pos:Int,ls:List[A]):(List[A],List[A]) = ls.splitAt(pos)
  def splitFunctional[A](n:Int,ls:List[A]):(List[A],List[A]) = (ls.take(n),ls.drop(n))

  //P18
  def slice[A](start:Int,end:Int, ls:List[A]) = ls.drop(start).take(end-start)

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
}



