package algorithms

import scala.annotation.tailrec


/**
 * Recursion : A function call/referred to itself
 *  - 1. Identify the base case
 *  - 2. Identify the recursive case
 *  - 3. Get closer and closer and return when needed. Usually you have 2 returns
 */
object Recursion extends App {

  /**
   * Exercise 1:
   *  1. Write 3 functions that finds the factorial of any number
   *      - one should use recursive
   *      - 2nd should use tail-recursive
   *      - 3rd should use a for loops
   *
   */

  /**
   * Time Complexity : O(n)
   * Space Complexity : O(1)
   * @param number
   * @return
   */
  def findFactorialRecursive(number : Int) : Int = {
    if (number == 2)  return 2
    number * findFactorialRecursive(number-1)
  }

  /**
   * Time Complexity : O(n)
   * Space Complexity : O(1)
   *
   * @param number
   * @return
   */
  def findFactorialTailRecursive(number: Int) : Int = {

    @tailrec
    def findRecursiveHelper(number: Int, accumulator: Int) : Int = {
      if (number == 1) return accumulator
      findRecursiveHelper(number-1, number * accumulator)
    }

    findRecursiveHelper(number, 1)
  }

  /**
   * Time Complexity : O(n)
   * Space Complexity : O(1)
   * @param number
   * @return
   */
  def findFactorialIterative(number: Int) : Int = {
    var result : Int = 1
    for(i <- 2 to number) {
      result = result * i
    }
    result
  }

  println(s"Factorial with Recursive : ${findFactorialRecursive(10)}")
  println(s"Factorial with Tail Recursive : ${findFactorialTailRecursive(10)}")
  println(s"Factorial with Iterative : ${findFactorialIterative(10)}")

}