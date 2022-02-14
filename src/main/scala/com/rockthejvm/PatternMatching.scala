package com.rockthejvm

object PatternMatching extends App{

  //switch statement expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case _ => anInteger + "th"
  }

  //PM is an expression

  println(order)

  case class Person(name: String, age: Int)

  val bob = Person("Bob" , 55)//Person.apply("Bob", 55)

  //Case class decomposition
  var personGreeting = bob match {
    case Person(n,a)=> s"Hi my name is $n and I am $a years old."
    case _ => "SOmething else"
  }

  println(personGreeting)

  var aTuple = ("Bon Jovi" , "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ =>"IDK what is this."
  }

  println(bandDescription)

  val aList = List(1,2,3)

  val listDescription = aList match {
    case List(_,2,_) => "Contains 2 on 2nd position"
    case _ => "unknown list"
  }

  println(listDescription)

  //if PM doesnt match anything, it will throw a MatchError
  //PM will try all cases in sequence






}
