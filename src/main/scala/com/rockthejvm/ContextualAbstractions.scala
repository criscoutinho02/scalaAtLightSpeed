package com.rockthejvm

object ContextualAbstractions {

  /*
  1 - context parameters/arguments
   */

  val aList = List(100,4,1,2,3)
  val anOrderedList = aList.sorted //contextual argument (descendingOrdering)

  //ordering
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_>_) //(a,b)=> a>b

  //given is analogous to implicit val
  trait Combinator[A]{ //mathematicaly monoid
    def combine(x: A, y : A): A
  }


  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce((a,b) => combinator.combine(a,b))

  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }
  val theSum = combineAll(aList) //intCombinator

  /**
   *
   * Given places
   * - local scope
   * - imported scope
   * - the companions of all the types involved in the call
   *    -companion of list
   *    -companion od int
   */


  //context bounds
  def combineAll_v2[A](list: List[A])(using Combinator[A]): A = ???
  def combineAll_v3[A : Combinator](list: List[A]): A = ??? //reads as [A] : Combinator - [A] A must have a given type Combinator[A] on scope

  /*
  where context args are useful
    -type classes
    - dependency injection
    - context-dependent functionality
    - type-level programming
  */

  /*
  2 - extension methods
  add aditional methods to a type
  */

  case class Person(name: String){
    def greet(): String = s"Hi, my name is $name"
  }

  extension (string:String)
    def greet(): String = Person(string).greet()

  val danielsGreeting = "Daniel".greet() //"type enrichment" = pimping

  //POWER
  extension [A](list : List[A])
    def combineAllValues(using combinator: Combinator[A]): A =
      list.reduce(combinator.combine)

  val theSumv2 = aList.combineAllValues

  def main(args: Array[String]): Unit = {
    println(anOrderedList)
    println(theSum)
    println(danielsGreeting)
    println(theSumv2)
  }

}
