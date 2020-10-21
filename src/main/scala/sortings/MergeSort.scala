package sortings

/**
 *  Time Complexity : O(nlogn)
 *  Space Complexity : O(n)
 *  Paradigm: Divide and Conquer
 */
object MergeSort extends App {

  private val elements: Array[Int] = Array(12, 11, 13, 5, 6, 7)

  mergeSort(elements, 0, elements.length - 1)

  println(elements.mkString(", "))

  def mergeSort(elements: Array[Int], lowerIndex: Int, higherIndex: Int): Unit = {
    if(lowerIndex < higherIndex){
      val midIndex = (lowerIndex + higherIndex) / 2
      mergeSort(elements, lowerIndex, midIndex)
      mergeSort(elements, midIndex + 1, higherIndex)
      merge(elements, lowerIndex, midIndex, higherIndex)
    }
  }

  def merge(elements: Array[Int], lowerIndex: Int, midIndex: Int, higherIndex: Int): Unit = {
    // Find sizes of two sub-arrays to be merged
    val leftSize = midIndex - lowerIndex + 1
    val rightSize = higherIndex - midIndex

    /* Create temp arrays */
    val left = new Array[Int](leftSize)
    val right = new Array[Int](rightSize)

    /*Copy data to temp arrays*/
    for(i <- left.indices) left(i) = elements(lowerIndex + i)
    for(j <- right.indices) right(j) = elements(midIndex + 1 + j)

    /* Merge the temp arrays */

    // Initial indexes of first and second sub-arrays
    var leftIndex = 0
    var rightIndex = 0

    // Initial index of merged sub-array
    var resultIndex = lowerIndex

    while(leftIndex < leftSize && rightIndex < rightSize) {
      if(left(leftIndex) < right(rightIndex)) {
        elements(resultIndex) = left(leftIndex)
        leftIndex += 1
      } else {
        elements(resultIndex) = right(rightIndex)
        rightIndex += 1
      }
      resultIndex += 1
    }

    /* Copy remaining elements of left[] if any */
    while (leftIndex < leftSize) {
      elements(resultIndex) = left(leftIndex)
      resultIndex += 1
      leftIndex += 1
    }

    /* Copy remaining elements of right[] if any */
    while (rightIndex < rightSize) {
      elements(resultIndex) = right(rightIndex)
      resultIndex += 1
      rightIndex += 1
    }

  }
}