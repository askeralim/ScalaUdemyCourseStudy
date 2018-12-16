package study.lectures.part3.collection

import scala.util.Random

object SequencesBasics extends App{
  val seq = Seq(1,2,3,4,5)
  println(seq)
  println(seq.reverse)
  println(seq ++ (Seq(9,8,7,6).sortBy(b=>b%2!=0)))
  println(seq(2)) // It gets the Third Element from the sequence
  //Range
  val aRange = 1 to 10
  aRange.foreach(a=>print(" "+a))

  //Otherwise short hand
  (1 to 10).foreach(a=>print(" "+a))

  //List
  val aList = List(1,2,3)
  val prepended = 21 :: aList
  println(prepended) // will print 21 1 2 3
  //Same above can be done as follows
  val prependedOther = 21 +: aList
  println(prependedOther) // will print List(21, 1, 2, 3, 33)

  //Prepend and Append
   val fullList = 12 +: aList :+33 // will print List(12, 1, 2, 3, 33)
  println(fullList)

  List.fill(5)("Asker").foreach(print) // It will fill 5 times "Asker" in the List

  //Arrays
  val array = Array(1,2,3,4)
  array.foreach(x=>print(x+" "))
  array(2)=0 // It will update teh array third value to zero
  println(array)

  val arraySequence:Seq[Int] = array // Implicit Conversion
  println(arraySequence)//It will convert the Object to WrappedArray(1, 2, 0, 4)

  //Vector is Fast in writing and Reading
  //Wrinting to a Vecor example
  val maxCapacity = 10000000
  def writeToCollection(collection:Seq[Int]):Double  = {
    val maxRuns = 10000

    val r = Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
  times.sum *1.0/maxRuns
  }
  val numberList = (1 to maxCapacity).toList
  val numbervector = (1 to maxCapacity).toVector
  println(writeToCollection(numberList))
  println(writeToCollection(numbervector))

  //Write to an Array Takes higher time than a Vector

}
