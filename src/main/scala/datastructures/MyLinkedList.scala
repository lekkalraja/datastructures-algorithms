package datastructures

object MyLinkedList extends App {


  private val linkedList: CustomLinkedList[Int] = CustomLinkedList(1)
  linkedList.append(2).append(4).append(6)
  linkedList.printElements()
  linkedList.insert(0,0)
  linkedList.printElements()
  linkedList.insert(linkedList.length, 7)
  linkedList.printElements()
  linkedList.insert(3, 3)
  linkedList.printElements()
  linkedList.insert(5,5)
  linkedList.printElements()
  linkedList.remove(4)
  linkedList.printElements()
  linkedList.remove(0)
  linkedList.printElements()

  object CustomLinkedList {
    def apply[T](element: T): CustomLinkedList[T] = {
      val node = Node(element)
      new CustomLinkedList(node, node, 1)
    }
  }

  class CustomLinkedList[T](var head: Node[T], var tail: Node[T], var length: Int) {

    def insert(index: Int, data : T) : CustomLinkedList[T] = {
      if(index == 0) prepend(data)
      else if (index >= length) append(data)
      else {
        val node = Node(data)
        val current = getCurrentNode(index)
        node.next = current.next
        current.next = node
      }
      this.length += 1
      this
    }

    def remove(index: Int) : CustomLinkedList[T] = {
      if ( index == 0) this.head = this.head.next
      else {
        val previousNode = getCurrentNode(index)
        val currentNode = previousNode.next
        previousNode.next = currentNode.next
      }
      this.length -= 1
      this
    }

    def prepend(element: T) : CustomLinkedList[T] = {
      val node = Node(element)
      node.next = head
      head = node
      length += 1
      this
    }


    def append(element: T) : CustomLinkedList[T]  = {
      val node = Node(element)
      tail.next = node
      tail = node
      length += 1
      this
    }

    def printElements(): Unit = {
      var temp = head
      while(temp != null) {
        print(s"${temp.data} \t")
        temp = temp.next
      }
      println()
    }

    private def getCurrentNode(index: Int) : Node[T] = {
      var current = head
      for(_ <- 1 until index) {
        current = current.next
      }
      current
    }
  }

  object Node {
    def apply[T](data : T) = new Node(null, data)
  }

  class Node[T](var next : Node[T], val data : T)
}