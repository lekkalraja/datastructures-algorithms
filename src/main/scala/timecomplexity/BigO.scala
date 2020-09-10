package timecomplexity

object BigO extends App {

  /**
   * What is Good Code ?
   *  Code that satisfies
   *    1. Readable
   *    2. Scalable  (BIG-O Helps)
   */


  /**
   * This Functions taking more time as input grows
   * i.e. number elements (input) vs operations (time taking) are directly proportions
   *
   * O(n) (LINEAR TIME) is the Asymptotic Notations(BIG-O) for this function
   */
  def printName(names: Array[String], name: String): Unit = {
    val start = System.currentTimeMillis()
    for (item <- names if item.equals(name)) {
      println(item)
    }
    val end = System.currentTimeMillis()

    // => This time may vary based on CPU's, Ram, load on OS in runtime of system
    println(s"Total Time Taken To Find $name is : ${end-start} millis")
  }

  val names = Array("Raja", "Rani", "Krishna", "Karna", "Duryodhana")
  printName(names, "Raja")

  private val moreNames: Array[String] = Array.fill(10000)("Raja")
  printName(moreNames, "Seeta")

  private val muchMoreNames: Array[String] = Array.fill(100000000)("Raja")
  printName(muchMoreNames, "Geeta")

  private val infiniteNames: Array[String] = Array.fill(200000000)("Raja")
  printName(infiniteNames, "Helen")


  /**
   * This function will always take 2 operations irrespective of input size
   *
   * O(1) - CONSTANT TIME
   */
  def printFirstTwoNames(names : Array[String]): Unit = {
    println(names(0))
    println(names(1))
  }

  /**
   * This Function having 1 level nested loop i.e. loop inside loop
   * so for every input of list iterating whole list
   * O(n^2^) QUADRATIC TIME
   */
  def logAllPairs(list: Array[Int]): Unit = {
    list.foreach(item => list.foreach(reitem => println(s"($item,$reitem)")))
  }

  logAllPairs(Array(1,2,3,4,5))
}
