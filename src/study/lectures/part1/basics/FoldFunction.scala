package study.lectures.part1.basics

object FoldFunction extends App{
  val numbers = List(5, 4, 8, 6, 2)
  val sum = numbers.fold(0) { (a, i) =>
    a + i
  }
  val product = numbers.fold(1) { (a, i) =>
    a * i
  }
  numbers.fold(true)(
    (item, i) => {println("Fold Right :"+item+"  i:"+i);i;}
  )
  println("Sum :"+ sum+" Product:"+product)

  class Foo(val name: String, val age: Int, val sex: Symbol)

  object Foo {
    def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
  }
  val fooList = Foo("Hugh Jass", 25, 'male) ::
    Foo("Biggus Dickus", 43, 'male) ::
    Foo("Incontinentia Buttocks", 37, 'female) ::
    Nil

  val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
    val title = f.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }
    z :+ s"$title ${f.name}, ${f.age}" //z:+ means it is adding the result into a List
  }
  println(stringList)

  val productListL = numbers.foldLeft(List[Int]()) { (a, i) =>
    a :+ i
  }

  val productListR = numbers.foldRight(List[Int]()) { (a, i) =>
    a +: i
  }
  println(productListL+"\n"+productListR)
}
