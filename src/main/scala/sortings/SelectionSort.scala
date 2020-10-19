package sortings

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 * (considering ascending order) from unsorted part and putting it at the beginning
 *
 *  Input         : 64, 25, 12, 22, 11
 *  1st Iteration : 11, 25, 12, 22, 64
 *  2nd Iteration : 11, 12, 25, 22, 64
 *  3rd Iteration : 11, 12, 22, 25, 64
 *  4th Iteration : 11, 12, 22, 25, 64
 */
object SelectionSort extends App {

  private val elements: Array[Int] = Array(64, 25, 12, 22, 11)

  /**
   * Time Complexity : O(n^2^)
   * Space Complexity : O(1)
   */
  for(i <- 0 until elements.length-1) {
    var smallest = elements(i)
    var index = i
    for(j <- i + 1 until elements.length)
      if(smallest > elements(j)) {
        smallest = elements(j)
        index = j
      }
    elements(index) = elements(i)
    elements(i) = smallest
    println(elements.mkString(", "))
  }
}