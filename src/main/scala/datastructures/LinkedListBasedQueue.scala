package datastructures

object LinkedListBasedQueue extends App {

  private val queue: Queue[Int] = Queue[Int]()
  (10 to 50 by 10).foreach(item => println(s"Enqueuing $item : ${queue.enqueue(item)}"))
  queue.printQueue()
  (1 to 5).foreach(_ => println(s"Peek : ${queue.peek()} & Length : ${queue.length}"))
  (1 to 4).foreach(_ => println(s"Dequeuing  : ${queue.dequeue()}  & Length : ${queue.length}"))
  println(s"Stack isEmpty : ${queue.isEmpty}")
  println(s"Dequeuing  : ${queue.dequeue()}  & Length : ${queue.length}")
  println(s"Stack isEmpty : ${queue.isEmpty}")
  println(s"Dequeuing  : ${queue.dequeue()}  & Length : ${queue.length}")

  object Queue {
    def apply[T](): Queue[T] = new Queue(null, null, 0)
  }

  class Queue[T](var first: Node[T], var last: Node[T], var length: Int) {

    def enqueue(element : T) : Boolean = {
      val node = Node(element)
      if ( this.length == 0 ) {
        this.first = node
        this.last = node
      }
      else {
        this.last.next = node
        this.last = node
      }
      this.length += 1
      true
    }

    def dequeue() : T = {
      if (this.length == 0) throw new NoSuchElementException
      val element = this.first.data
      this.first = this.first.next
      this.length -= 1
      element
    }

    def peek() : T = {
      if (this.length == 0) throw new NoSuchElementException
      this.first.data
    }

    def isEmpty : Boolean = this.length == 0

    def printQueue() : Unit = {
      var current = this.first
      while (current != null) {
        print(current.data)
        current = current.next
        if(current != null) print(" --> ")
      }
      println()
    }
  }

  object Node {
    def apply[T](data: T): Node[T] = new Node(null, data)
  }

  class Node[T](var next: Node[T], val data: T)
}
