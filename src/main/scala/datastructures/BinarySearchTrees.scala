/*
package datastructures

import scala.annotation.tailrec
import scala.math.Ordering

object BinarySearchTrees extends App {

  private val bst: BinarySearchTree[Int] = BinarySearchTree(11)
  bst.insert(16)
  bst.insert(6)
  bst.insert(19)
  bst.insert(14)
  bst.insert(5)
  bst.insert(10)

  bst.lookup(30)
  bst.lookup(6)



  object BinarySearchTree {
    def apply[T](element: T): BinarySearchTree[T] = {
      val root = Node(element)
      new BinarySearchTree(root)
    }
  }

  class BinarySearchTree[A](val root: Node[A]) {

    implicit def ordering[A]: Ordering[A] = Ordering.fromLessThan((_, _) => true)

    def insert[A](element: A) : BinarySearchTree[A] = {
      val newNode = Node(element)
      attachToNode(root, newNode)
      this
    }

    @tailrec
    private def attachToNode[A](node: Node[A], newNode: Node[A])(implicit ord: Ordering[A]): Unit = {
      import ord.mkOrderingOps
      if(node.data >= newNode.data) {
        if (node.right != null) attachToNode(node.right, newNode)
        else node.right = newNode
      } else {
        if (node.left != null) attachToNode(node.left, newNode)
        else node.left = newNode
      }
    }

    def lookup(element : A) : Node[A] = {

      @tailrec
      def lookupHelper(node : Node[A])(implicit ord: Ordering[A]) : Node[A] = {
        import ord.mkOrderingOps
        if (node == null) return null
        if(element == node.data) node
        else {
          if(element < node.data) {
            lookupHelper(node.left)
          } else {
            lookupHelper(node.right)
          }
        }
      }
      lookupHelper(this.root)
    }

    def remove(element : A) : Boolean = ???
  }

  object Node {
    def apply[A](data: A): Node[A] = new Node(null, null, data)
  }

  class Node[A](var left: Node[A], var right: Node[A], var data: A)
}*/
