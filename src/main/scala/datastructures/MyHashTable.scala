package datastructures

import scala.collection.mutable
import scala.reflect.ClassTag

object MyHashTable extends App {

  private val myHash: HashTable[String, Int] = HashTable[String, Int](30)
  myHash.set("Raja", 26)
  myHash.set("Rani", 25)
  myHash.set("Krishna", 2)

  println("Raja : "+ myHash.get("Raja"))
  println("Rani : "+ myHash.get("Rani"))
  println("Krishna : "+ myHash.get("Krishna"))
  println(s"Size : ${myHash.length}")

  myHash.keys().foreach(println)


  object HashTable {
    def apply[K, V](size: Int) : HashTable[K, V] = new HashTable[K, V](size)
    def apply[K, V]() : HashTable[K, V] = new HashTable[K, V](20) // default is 20
  }

  class HashTable[K, V](size: Int) {

    private val data = new Array[(K, V)](size)
    var length = 0


    /**
     * Time Complexity is => O(1) because accessing from Array is O(1)
     */
    def get(key: K): V = {
      val index = hashCode(key)
      // TODO: Think about collisions
      data(index)._2
    }

    /**
     * Time Complexity is => O(1) because inserting an element to finite array is O(1)
     */
    def set(key: K, value: V): (K, V) = {
      val index = hashCode(key)
      // TODO: Think about collisions
      data(index) = (key, value)
      length += 1
      (key, value)
    }

    def hashCode(key: K): Int = key.hashCode() % size

    def keys[K:ClassTag](): Array[K] = data.filter(_ != null).map(_._1.asInstanceOf[K])
  }

  /**
   * Exercise : Given an array find first recurring character
   *  input 1 : [2,5,1,2,3,5,1,2,4] => should return 2
   *  input 2 : [2,1,1,2,3,5,1,2,4] => should return 1
   *  input 3 : [2,3,4,5] => should return undefined
   */

  /**
   * Time Complexity => O(n)
   * Space Complexity => O(n)
   */
  def findRecurringCharacterWithArray[T: ClassTag](input: Array[T]) : Option[T] = {
    val dup = new Array[T](input.size)
    var index = 0
    input.foreach { item =>
      if(dup.contains(item)) { // Array search / Contains may O(n) because it will search with value instead of key
        return Option(item)
      }
      dup(index) = item
      index += 1
    }
    Option.empty
  }

  def findRecurringCharacterWithHashTable[T: ClassTag](input: Array[T]) : Option[T] = {
    val dup = new mutable.HashMap[T, Any]()
    var index = 0
    input.foreach { item =>
      if(dup.contains(item)) { // Hash search with key will happen O(1), so better to use Hash instead of Array
        return Option(item)
      }
      dup.put(item, 1)
      index += 1
    }
    Option.empty
  }



  findRecurringCharacterWithHashTable(Array(2,5,1,2,3,5,1,2,4)).foreach(println)
  findRecurringCharacterWithHashTable(Array(2,1,1,2,3,5,1,2,4)).foreach(println)
  findRecurringCharacterWithHashTable(Array(2,5,1,6)).foreach(println)
}