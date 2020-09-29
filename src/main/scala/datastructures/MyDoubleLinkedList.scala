package datastructures

object MyDoubleLinkedList extends App {


  private val myDoublyLinkedList: DoublyLinkedList[Int] = DoublyLinkedList(4)

  myDoublyLinkedList.append(3).append(2).prepend(6).append(1).prepend(7).append(0)
  myDoublyLinkedList.insert(5, 5)
  myDoublyLinkedList.printElements()
  myDoublyLinkedList.remove(3)
  myDoublyLinkedList.printElements()

  object DoublyLinkedList {
    def apply[T](element: T): DoublyLinkedList[T] = {
      val node = Node(element)
      new DoublyLinkedList(node, node, 1)
    }
  }

  class DoublyLinkedList[T](var head: Node[T], var tail: Node[T], var length: Int) {

    def remove(index: Int) : DoublyLinkedList[T] = {
      val currentNode = getNode(index)
      currentNode.previous.next = currentNode.next
      currentNode.next.previous = currentNode.previous
      this.length -= 1
      this
    }

    def insert(index: Int, element: T) : DoublyLinkedList[T] = {
      val node = Node(element)
      val currentNode = getNode(index)
      currentNode.previous.next = node
      node.previous = currentNode.previous
      currentNode.previous = node
      node.next = currentNode
      this.length += 1
      this
    }

    private def getNode(index: Int) : Node[T] = {
      var currentNode = head
      var count = 0
      if( index <= length / 2) {
        while(count != index) {
          currentNode = currentNode.next
          count += 1
        }
      } else {
        val tailIndex = length - index - 1
        currentNode = tail
        while(count != tailIndex) {
          currentNode = currentNode.previous
          count += 1
        }
      }
      currentNode
    }

    def prepend(element: T) : DoublyLinkedList[T] = {
      val node = Node(element)
      tail.next = node
      node.previous = tail
      tail = node
      this.length += 1
      this
    }

    def append(element: T) : DoublyLinkedList[T] = {
      val node = Node(element)
      node.next = head
      head.previous = node
      head = node
      this.length += 1
      this
    }

    def printElements() : Unit = {
      print("Forward   :  ")
      printForwardElements()
      print("Backward  :  ")
      printBackwardElements()
    }

    def printForwardElements() : Unit = {
      var current = head
      while (current != null) {
        print(s"${current.data} \t")
        current = current.next
      }
      println()
    }

    def printBackwardElements() : Unit = {
      var current = tail
      while( current != null ) {
        print(s"${current.data} \t")
        current = current.previous
      }
      println()
    }
  }

  object Node {
    def apply[T](data: T): Node[T] = new Node(null, null, data)
  }

  class Node[T](var next: Node[T], var previous: Node[T], val data: T)
}
