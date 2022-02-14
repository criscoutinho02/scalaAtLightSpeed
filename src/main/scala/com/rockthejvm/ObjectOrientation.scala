package com.rockthejvm

object ObjectOrientation extends App{

  class Animal
  {
    //define fields
    val age: Int = 1
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  //inheritance

  class Dog(val name: String) extends Animal
  val aDog = new Dog("Rocky")

  //constructor arguments are not a field: need to put a val before the constructor argument

  aDog.name

  val aDeclaredAnimal: Animal = new Dog("Ariel")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  //abstract class
  abstract class WalkinAnimal{
    val hasLags = true //by default public

    def wals() : Unit
  }
  //interface = ultimate abstract type

  trait Carnivore{
    def eat(animal: Animal): Unit
  }
  //single class inheritance multi-trait "mixing
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I eat you")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought" )
  }

  trait Philosopher{
    def ?!(thought: String): Unit //valid method name
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // only available for methods with one argument
  aCroc ?! "VAMOS MORRER"


  //OPERATORS IN SCALA ARE ACTUALLY METHODS

  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  //anonymous class
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("i am a dinossaur eatings")
  }

  //singletonObject

  object MySingleton { //the only instance of the MySingleton type
    val mySpecialValue = 54789

    def mySpecialMethod(): Int = 5327

    def apply(x: Int): Int = x+1
  }

    MySingleton.mySpecialMethod()
    MySingleton.apply(65)
    MySingleton(65) //equivalent to MySingleTon.apply

    object Animal{//companions = companion object
      //companions can access each other'' private fields/methods
      //singleton Animal and instances of animal are different things
      val canLiveIndefinetely = false

    }

    val animalsCanLiveIndefniitely = Animal.canLiveIndefinetely //"static" fields/methods

    //case class = lightweight  data structures with some boileplate
    //sensible equals and hashcode
    //serialization
    //companion with apply
    case class Person(name: String, age: Int)

    //may be constructed without new
    val bob = new Person("Bruno", 54)
    val cris = Person("Cris" , 30)//Person.apply("Cris", 30)


    //exceptions
    try{
        //code can throw
      val x: String = null
      x.length
    } catch{
      case e: Exception => "some exception"
    } finally {
      //execute some code no matter what
    }

    //generics
    abstract class MyList[T]{
      def head: T
      def tail: MyList[T]
    }
    //using a generic with a concrete type
    val aList: List[Int]= List(1,2,3)  //List.apply(1,2,3)
    val first = aList.head

    val rest = aList.tail


    val aStringList =  List("Hello", "Scala")
    val firstString = aStringList.head

    //Point #1 : in Scala we usually operate with IMMUTABLE values/objects
    //Any modification to an oject must return ANOTHER object
    /*
      Benefits:
      1) works miracle in multithreaded/distributed env
      2) helps making sense of the code ("reasoning about")
     */
    val reversedList = aList.reverse //returns a new list
    //Point #2 : Scala is closest to the 00 ideal









}
