package com.rockthejvm

object FunctionalProgramming extends App{
  //Scala is OO
  class Person(name: String){
    def apply(age: Int) = println(s"I have aged $age years")

  }

  val bob = new Person("bob")
  bob(43) //== bob.apply(43)

  /*
  SCALA RUNS ON THE JVM
  Functional programming:
  -compose functions
  -pass functions as args
  -return function as results
  Conclusion: FunctionX

  */

  val simpleIncrementer = new Function1[Int, Int]{ //trait
    override def apply(arg: Int): Int = arg +1
  }

  simpleIncrementer.apply(33)
  simpleIncrementer(33)

  //define a function!
  //all scala functions are instances of these FUNCTIONS_X TYPES

  val stringConcatenator = new Function2[String , String , String]{
    override def apply(v1: String, v2: String): String = v1 + v2
  }


  println(stringConcatenator("I love" , "Scala"))

  //syntax sugars
  val doubler: Function1[Int, Int]= (x: Int)=>2*x
  println(doubler(4))
  /*
  equivalent to the much longer:
  new Function1[Int,Int]{
    override defapply(x:Int) = 2 * x
  }
   */

  val doubler2: Int => Int = (x:Int)=>2*x
  /*
   equivalent to the much longer:
   val doubler2 = Function1[Int,Int] = new Function1[Int,Int]{
     override def apply(x:Int) = 2 * x
   }
    */
  val doubler3 = (x:Int)=>2*x
  println(doubler3(4))

  //higher-order functions: take functions as args/return functions as results => HOF

  val aMappedList = List(1,2,3).map(x=>x+1) //HOF
  val aMappedList2: List[Int] = List(1,2,3).map(x=>x+1) //HOF
  println(aMappedList)


  //flat map
  val aFlatMappedList = List(1,2,3).flatMap(x=>List(x,2*x))
  println("aFlatMappedList")
  println(aFlatMappedList)
  val aFlatMappedList2 = List(1,2,3).flatMap{
    x=>List(x,2*x)
  }//ALTERNATIVE SYNTAX = same as previous


  val aFilteredList = List(1,2,3,4,5).filter(x=> x <=3)
  println("aFilteredList")
  println(aFilteredList)


  val aFilteredList2 = List(1,2,3,4,5).filter(_<=3) //equivalent to previous syntax

  //all pairs between numbers 1,2,3 and the letters a , b , c
  val allPairs = List(1,2,3).flatMap(number => List('a','b','c').map(letter=>s"$number-$letter"))
  println("allPairs")
  println(allPairs)

  //for comprehensions is a expression
  val alternativePairs = for {
    number<- List(1,2,3)
    letter<- List('a', 'b', 'c')
  }yield s"$number-$letter"
  //equivalent to the previous implementation

  println("alternativePairs")
  println(alternativePairs)
  /*
  Collections
  map and flatmap works for all collections
   */

  //lists -
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val lastElement = aList.tail

  println(firstElement)
  println(lastElement)
  val aPrependedList = 0 :: aList //List(0,1,2,3,4,5)
  println("aPrependedList")
  println(aPrependedList)

  val anExtendedList = 0+: aList :+ 6 //appends an element to an list
  println("anExtendedList")
  println(anExtendedList)

  //sequences - Seq is a trait , an abstract type
  val aSequence: Seq[Int] = Seq(1,2,3)
  val acessedElement = aSequence(2) // the element at index 1:2
  println("acessedElement")
  println(acessedElement)


  //vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)
  println("aVector")
  println(aVector)

  //sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3)
  println("aSet")
  println(aSet)
  val setHas5 = aSet.contains(5)
  println(s"setHas5: $setHas5")
  val anAddedSet = aSet + 5
  println(s"anAddedSet => $anAddedSet")
  val aRemovedSet = aSet - 5
  println(s"aRemovedSet => $aRemovedSet")

  //ranges
  val aRange = 1 to 1000
  println("aRange")
  println(aRange)
  val twoByTwo = aRange.map(x=>2*x).toList
  println("twoByTwo")
  println(twoByTwo)

  //tuples
  val aTuple = ("Bon Jovi", "Rock" , 1982)
  println(s"aTuple -> $aTuple")

  //maps
  val aPhoneBook: Map[String, Int]= Map(
    "Jane"-> 1487455 ,
    "Daniel" -> 486513
  )
  println("aPhoneBook")
  println(aPhoneBook)





}
