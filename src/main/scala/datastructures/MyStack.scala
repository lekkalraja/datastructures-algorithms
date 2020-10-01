package datastructures

object MyStack extends App {

  private val stack: Stack[Int] = Stack[Int]()
  (10 to 50 by 10).foreach(item => println(s"Pushing $item : ${stack.push(item)}"))
  stack.printStack()
  (1 to 5).foreach(_ => println(s"Peek : ${stack.peek()} & Length : ${stack.length}"))
  (1 to 4).foreach(_ => println(s"Pop  : ${stack.pop()}  & Length : ${stack.length}"))
  println(s"Stack isEmpty : ${stack.isEmpty}")
  println(s"Pop  : ${stack.pop()}  & Length : ${stack.length}")
  println(s"Stack isEmpty : ${stack.isEmpty}")
  println(s"Pop  : ${stack.pop()}  & Length : ${stack.length}")

  object Stack {
    def apply[T]() : Stack[T] = new Stack(null, 0)
  }

  class Stack[T](var top : Node[T], var length : Int) {

    def push(element: T) : Boolean = {
      val current = Node(element)
      if( this.length == 0) this.top = current
      else {
        current.bottom = this.top
        this.top = current
      }
      length += 1
      true
    }

    def pop() : T = {
      if (isEmpty) throw new NoSuchElementException
      val element = this.top.data
      this.top = this.top.bottom
      this.length -= 1
      element
    }

    def peek() : T = {
      if (isEmpty) throw new NoSuchElementException
      this.top.data
    }

    def printStack() : Unit = {
      var current = this.top
      println("================STACK ELEMENTS================")
      while(current != null) {
        println(s"    ${current.data}   ")
        current = current.bottom
        if(current != null) println(s"    |         ")
      }
      println("================STACK ELEMENTS================")

    }
    def isEmpty: Boolean = this.length == 0

  }

  object Node {
    def apply[T](data: T): Node[T] = new Node(null, data)
  }
  class Node[T](var bottom: Node[T], val data: T)
}
