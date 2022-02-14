package com.rockthejvm

object Basics extends App {
  //defining a value
  val meaningOfLife: Int= 42 //const int meaningOfLife = 42
  //Int Boolean Char , Double Float String
  val aBoolean = false //type is optional

  //strings ans stringsOperations
  val aString = "I love Scala"
  val aComposedString = "I" + " love" + " Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expression = structures that can be reduced to a value
  val anExpression = 2+3
  val ifExpression = if(meaningOfLife>43)56 else 9999 //in other languages: meaningofLife>43 ?56 :999
  val chainedExpression =
    if (meaningOfLife>43)56
    else if (meaningOfLife<0) -2
    else if (meaningOfLife > 999) 78
    else 0

  println(chainedExpression)

  //codeblocks
  val aCodeBlock ={
    //definitions
    val alocalValue = 67
    alocalValue+3
  }
  println(aCodeBlock)

  //define a function
  def myFunction(x: Int , y:String): String = {
    y + " " + x
  }

  //recursiveFunction
  def factorial(n: Int):Int =
    if(n<=1)1
    else n*factorial(n-1)

  println(factorial(5))

  //In scala we dont use loops iteration we use RECURSION

  //the Unit return type - no meaningful value = void
  //the type of sideeffects
  println("println returns a UnitType") //sout

  def myUnitReturningFuncion() : Unit = {
    println("I dont love returning Unit")
  }
  myUnitReturningFuncion()


}
