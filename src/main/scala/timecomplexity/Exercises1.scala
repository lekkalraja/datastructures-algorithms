package timecomplexity

object Exercises1 extends App {

  /**
   * Given 2 arrays, create a function that let's user know (true/false)
   * whether these two arrays contain any common items.
   *
   * For Ex:
   *      array1 = [a,b,c,x]
   *      array2 = [z,y,i]
   *      output = false
   *
   *      array1 = [a,b,c,x]
   *      array2 = [x,z,y]
   *      output = true
   */

  /**
   * O(m*n) == O(n^2^) => Time Complexity == Quadrant
   * O(1) => Space Complexity (Not creating any objects/allocation space at runtime)
   * @param array1 of size 'm'
   * @param array2 of size 'n'
   * @return
   */
  def containsCommon1(array1: Array[Char], array2: Array[Char]) : Boolean = array1.exists(char1 => array2.contains(char1))

  println(containsCommon1(Array('a','b','c','x'), Array('z','y','i'))) // false
  println(containsCommon1(Array('a','b','c','x'), Array('z','y','x'))) // true

  /**
   * O(n+m) == O(n) ==> Time Complexity == Linear
   * O(n) ==> Space Complexity (Creating Map and storing data at the runtime)
   *
   * Better Solution than containsCommon1
   * @param array1
   * @param array2
   * @return
   */
  def containsCommon2(array1: Array[Char], array2: Array[Char]) : Boolean = {
    /*val data = collection.mutable.Map[Char, Boolean]()
     array1.foreach(char1 => data.put(char1, true)) // O(n)
     array2.exists(char2 => data.contains(char2))
    */

    /*val data = scala.collection.mutable.HashSet[Char]()
    array1.foreach(char1 => data(char1)) // O(n)
    array2.exists(char2 => data.contains(char2)) //O(m)*/

    array2.exists(char => array1.contains(char))
  }

  println(containsCommon1(Array('a','b','c','x'), Array('z','y','i'))) // false
  println(containsCommon1(Array('a','b','c','x'), Array('z','y','x'))) // true
}