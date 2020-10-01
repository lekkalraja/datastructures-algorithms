package datastructures

import scala.reflect.ClassTag

object ArrayBasedStack extends App {

  private val stack: Stack[Int] = Stack[Int]()
  (10 to 50 by 10).foreach(item => println(s"Pushing $item : ${stack.push(item)}"))
  stack.printStack()
  (1 to 5).foreach(_ => println(s"Peek : ${stack.peek()} & Length : ${stack.pointer}"))
  (1 to 4).foreach(_ => println(s"Pop  : ${stack.pop()}  & Length : ${stack.pointer}"))
  println(s"Stack isEmpty : ${stack.isEmpty}")
  println(s"Pop  : ${stack.pop()}  & Length : ${stack.pointer}")
  println(s"Stack isEmpty : ${stack.isEmpty}")
  println(s"Pop  : ${stack.pop()}  & Length : ${stack.pointer}")

  object Stack {
    def apply[T:ClassTag](): Stack[T] = new Stack(new Array[T](100), 0)
  }

  class Stack[T](val data: Array[T], var pointer: Int) {

    def push(element : T) : Boolean = {
      pointer += 1
      this.data(pointer) = element
      true
    }

    def pop() : T = {
      if (this.pointer == 0) throw new NoSuchElementException
      val element = this.data(pointer)
      this.pointer -= 1
      element
    }

    def peek() : T = {
      if (this.pointer == 0) throw new NoSuchElementException
      this.data(pointer)
    }
    
    def isEmpty : Boolean = this.pointer == 0

    def printStack() : Unit = {
      var current = this.pointer
      println("================STACK ELEMENTS================")
      while(current != 0) {
        println(s"    ${data(current)}   ")
        current = current-1
        if(current != 0) println(s"    |         ")
      }
      println("================STACK ELEMENTS================")
    }
  }
}