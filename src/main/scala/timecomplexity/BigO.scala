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
   * O(n) (Linear Time) is the Asymptotic Notations(BIG-O) for this function
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
}
