package datastructures

object MyArrays extends App {

  /**
   * ARRAY => BUILT IN DATA STRUCTURE
   */
  /*private val ints = Array(1,2,3,4,5)

  private val myInts: MyArray[Int] = MyArray(1, 2, 3, 4, 5)

  object MyArray {
    def apply[T](length: Long) : MyArray[T] = new MyArray[T](length)

    def apply[T](x: T, xs: T*) : MyArray[T] = {
      val myArray = new MyArray[T](xs.length + 1)
      myArray(0) = x
      val iterator = xs.iterator
      var i : Int = 1
      while(iterator.hasNext) {
        myArray(1) = iterator.next()
        i += 1
      }
      myArray
    }
  }

  class MyArray[T](length: Long) {
    def apply(index: Long) : T = throw new NotImplementedError
    def push(value: T) = throw new NotImplementedError
    def pop() : T = throw new NotImplementedError
    def foreach(fn : T => Unit) : Unit = throw new NotImplementedError
    def update(index: Long, value: T): T = throw new NotImplementedError
  }

  case class MyArrayData[T] (index: Long, value: T)  */

  /**
   * Exercise : Create a function that reverses a string
   *
   * Time Complexity := O(n)
   * Space Complexity := O(n)
   *
   * NOTE: Check for Valid input as always
   */

  def reverse(input: String) : String = {
    val source = input.toCharArray
    var lastIndex = source.length - 1
    var index = 0
    val result = new Array[Char](source.length)

    while(lastIndex >= 0 ) {
      result(index) = source(lastIndex)
      lastIndex -= 1
      index += 1
    }
    result.mkString("")
  }

  def reverseWithTailRecursion(input: String) : String = {
    val source = input.toCharArray
    val length = source.length - 1

    def reverseHelper(inputChar: Char, sourceIndex: Int,index: Int, result : Array[Char]): String = {
      result(index) = inputChar
      if(sourceIndex == 0) result.mkString("")
      else reverseHelper(input(sourceIndex-1), sourceIndex - 1,index + 1, result)
    }

    reverseHelper(source(length), length, 0, new Array[Char](length + 1))
  }

  def smartReverse(input: String) : String = input.reverse

  println(reverse("Hello, I am Rajasekhar!"))
  println(reverseWithTailRecursion("Hello, I am Rajasekhar!"))
  println(smartReverse("Hello, I am Rajasekhar!"))

  /**
   * Exercise : merge sort arrays
   *      input1 : [0,3,4,31]
   *      input2 : [4,6,30]
   *      mergeSortedArrays(input1,input2) => [0,3,4,4,6,30,31]
   *
   * Time Complexity : O(a + b) => O(n) (Linear)
   * Space Complexity : O(p + q) => O(n)
   */

  def mergeSortedArrays(input1 : Array[Int], input2: Array[Int]) : Array[Int] = {
    if (input1 != null && input1.length == 0) return input2
    if (input2 != null && input2.length == 0) return input1
    val resultLength = input1.length + input2.length
    val result = new Array[Int](resultLength)
    var pointer = 0
    var input1Index = 0
    var input2Index = 0
    while(pointer != resultLength) {
      if (input1Index == input1.length) {
        result(pointer) = input2(input2Index)
        input2Index += 1
      }else if(input2Index == input2.length)  {
        result(pointer) = input1(input1Index)
        input1Index += 1
      }else if (input1(input1Index) < input2(input2Index)) {
        result(pointer) = input1(input1Index)
        input1Index += 1
      } else {
        result(pointer) = input2(input2Index)
        input2Index += 1
      }
      pointer += 1
    }
    result
  }

  println(mergeSortedArrays(Array(0,3,4,31), Array(4,6,30)).toList) // toList is just to print


}
