package com.coursera.algorithm.part3.week1

/**
  * Created by sunilpatil on 1/8/17.
  */
class Stack[T:Manifest](size: Int) {
  var elem: Array[T] = new Array[T](size)
  var counter:Int = 0

  def push(v:T): Unit ={
    elem(counter) = v
    counter = counter+1
  }

  def pop():T={
    counter = counter -1
    val retValue = elem(counter)
    retValue
  }

  def peek():T ={
    elem(counter)
  }

  def length():Int ={
    counter
  }

  def empty():Boolean={
    counter == 0
  }


  override def toString = elem.mkString(", ")
}

object Stack{
  def main(argv: Array[String]): Unit ={
    val s = new Stack[Int](10)

    s.push(10)
    s.push(9)
    s.push(8)

    println(s)

    println(s.pop())
    println(s.pop())

  }

}