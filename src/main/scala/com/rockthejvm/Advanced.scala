package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{
  /**
  lazy evaluation
   **/
  lazy val aLazyValue = 2
  lazy val lazyValWithSideEffects ={
    println("I am so very lazy!")
    43
  }
  //useful in infinite collections
  val eagerValue = lazyValWithSideEffects + 1

  //"pseudo-collection": Option, Try
  def methodWithCanReturnNull(): String ="hello, Scala"
  val anOption = Option(methodWithCanReturnNull()) //Some("hello, Scala")
  //option = collection which contains at most 1 element:Some(value) or None - None regular value

  val stringProcessing = anOption match {
    case Some(string)=> s"Valid String $string"
    case None => "I have Nothing"
  }
  println(stringProcessing)

  /*traditional pov*/
//  if(methodWithCanReturnNull() == null){
//    //defensive code against null
//  }


  //TRY
  def methodWithCanThrowException(): String = throw new RuntimeException
  /**
  *
    TRADITIONAL POV
   **/

  val aTry = Try(methodWithCanThrowException())
  //a try collection with a value if the code went well , or an exception if the code threw one


  val anotherStringProcessing = aTry match {
    case Success(value)=>s"I have a valid string $value"
    case Failure(exception)=> s"I have an exception $exception"
  }

  println(anotherStringProcessing)

//  try{
//    methodWithCanThrowException()
//  }catch {
//    case e: Exception => "defending against interception"
//  }

  /**
    Evaluate something on another thread
    (asychronous programming)
   **/

  val aFuture = Future{ //Future.apply
    println("loading ...")
    Thread.sleep(1000)
    println("I have a computed value")
    67
  }

  Thread.sleep(2000)

  //future is a collection which contains a value when it'' evaluated
  //future is composable with map , flatmap and filter
  //monads are a subject very abstract and hard to explain

  /**
    * Implicits basics
   **/
  //#1: Implicits arguments
  def aMethodWithImplicitsArgs(implicit arg:Int) = arg + 1
  implicit val myImplicitInt: Int = 46
  println(aMethodWithImplicitsArgs)//compiler finds the implicit args

  //#2: Implicits conversions
  implicit class MyRichInteger(n: Int){
    def isEven() = n%2 == 0
  }

  println(23.isEven())
  //use this careful



}
