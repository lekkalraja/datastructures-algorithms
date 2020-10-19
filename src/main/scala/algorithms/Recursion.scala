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
   *
   * @param number
   * @return
   */
  def findFactorialRecursive(number: Int): Int = {
    if (number == 2) return 2
    number * findFactorialRecursive(number - 1)
  }

  /**
   * Time Complexity : O(n)
   * Space Complexity : O(1)
   *
   * @param number
   * @return
   */
  def findFactorialTailRecursive(number: Int): Int = {

    @tailrec
    def findRecursiveHelper(number: Int, accumulator: Int): Int = {
      if (number == 1) return accumulator
      findRecursiveHelper(number - 1, number * accumulator)
    }

    findRecursiveHelper(number, 1)
  }

  /**
   * Time Complexity : O(n)
   * Space Complexity : O(1)
   *
   * @param number
   * @return
   */
  def findFactorialIterative(number: Int): Int = {
    var result: Int = 1
    for (i <- 2 to number) {
      result = result * i
    }
    result
  }

  println(s"Factorial with Recursive : ${findFactorialRecursive(10)}")
  println(s"Factorial with Tail Recursive : ${findFactorialTailRecursive(10)}")
  println(s"Factorial with Iterative : ${findFactorialIterative(10)}")
  println("=====================================================================")

  /**
   * Given a number N, return the index value of the Fibonacci sequence,
   * where the Sequence is 0,1,1,2,3,5,8,13,21,34,55,89,144,...
   * The Pattern of the sequence is that each value is the sum of the 2 previous values,
   * that means that for N=5 -> 2 + 3
   */


  /**
   * Time Complexity : O(n)
   * @param index
   * @return
   */
  def findFibonacciValueIterativeWithArray(index: Int) : Int = {
    val result = new Array[Int](index+1)
    result.update(0, 0)
    result.update(1, 1)
    for(i <- 2 to index) result.update(i, result(i-2) + result(i-1))
    result(index)
  }

  /**
   * Time Complexity : O(n)
   * @param targetIndex
   * @return
   */
  def findFibonacciValueIterative(targetIndex: Int): Int = {
    if (targetIndex < 2) return targetIndex
    if (targetIndex == 2) return 1
    var first, second = 1
    var index = 3
    while (index <= targetIndex) {
      val temp = first + second
      first = second
      second = temp
      if (index == targetIndex) return temp
      index = index + 1
    }
    0
  }

  /**
   * Time Complexity = O(2^n)^
   * @param targetIndex
   * @return
   */
  def findFibonacciValueRecursive(targetIndex: Int): Int = {
    if (targetIndex < 2) return  targetIndex
    findFibonacciValueRecursive(targetIndex - 1) + findFibonacciValueRecursive(targetIndex - 2)
  }

  /**
   * Time Complexity : O(n)
   * @param targetIndex
   * @return
   */
  def findFibonacciValueTailRecursive(targetIndex: Int): Int = {

    @tailrec
    def findFibonacciValueRecursiveHelper(first: Int, second: Int, temp: Int, index: Int) : Int = {
      if(targetIndex < 2) return targetIndex
      else if(index == targetIndex) return temp
      val tempV = first + second
      findFibonacciValueRecursiveHelper(second, tempV, tempV, index + 1)
    }
    findFibonacciValueRecursiveHelper(1, 1, 1, 2)
}

  println(s"Fibonacci with Iterative : ${findFibonacciValueIterative(22)}")
  println(s"Fibonacci with Iterative With Array : ${findFibonacciValueIterativeWithArray(22)}")
  println(s"Fibonacci with Recursive : ${findFibonacciValueRecursive(22)}")
  println(s"Fibonacci with Tail-Recursive : ${findFibonacciValueTailRecursive(22)}")
}