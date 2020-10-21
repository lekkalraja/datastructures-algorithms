package sortings

/**
 * Insertion sort is a simple sorting algorithm that the array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 */
object InsertionSort extends App {

  private val elements: Array[Int] = Array(64, 25, 12, 22, 11)

  /**
   * Time Complexity : O(n^2^) => For Almost sorted O(n)
   * Space Complexity : O(1)
   */
  for(i <- 1 until elements.length) {
    val temp = elements(i)
    var j = i - 1
    while (j >= 0 && elements(j) > temp) {
      elements(j + 1) = elements(j)
      j = j - 1
    }
    elements(j + 1) = temp
    println(elements.mkString(", "))
  }

}