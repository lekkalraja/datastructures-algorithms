package sortings

/**
 *  Moving Largest element to right in every step
 *   Input         : 6, 5, 3, 2, 9, 7, 8
 *   1st Iteration : 5, 3, 2, 6, 7, 8, 9
 *   2nd Iteration : 3, 2, 5, 6, 7, 8, 9
 *   3rd Iteration : 2, 3, 5, 6, 7, 8, 9
 *   4th Iteration : 2, 3, 5, 6, 7, 8, 9
 */
object BubbleSort extends App {

  private val elements: Array[Int] = Array(6, 5, 3, 2, 9, 7, 8)

  var isItSorted = false

  /**
   * Time Complexity : O(m*n) ~ O(n^2^) => where m is the number of elements in wrong position
   * Space Complexity : O(1)
   */
  while(!isItSorted) {
    isItSorted = true
    for(i <- 0 until elements.length -1) {
      if(elements(i) > elements(i + 1)) {
        isItSorted = false
        val temp = elements(i)
        elements(i) = elements(i + 1)
        elements(i + 1) = temp
      }
    }
    println(elements.mkString(","))
  }
}