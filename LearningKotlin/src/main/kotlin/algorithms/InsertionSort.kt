/**
 * An implementation of the InsertionSort algorithm with some basic time measurements.
 *
 * Time complexity for InsertionSort:
 * Best: n
 * Average: n^2
 * Worst: n^2
 */

package algorithms

import kotlin.random.Random

fun main(){
    val random = Random
    val size = 100000
    val numbers = IntArray(size)

    for (i in numbers.indices) numbers[i] = random.nextInt(0,size)

    /*
    println("Before:")
    printArray(numbers)
    insertionSort(numbers)
    println("\nAfter:")
    printArray(numbers)
    */

    var start: Long = System.currentTimeMillis()
    insertionSort(numbers)
    var end: Long = System.currentTimeMillis()
    println("Time lapsed: ${end - start} ms for insertion sort.")

    start = System.currentTimeMillis()
    isSortedAscending(numbers)
    end = System.currentTimeMillis()
    println("\n\u001B[0mTime lapsed: ${end - start} ms for ensuring sorted ascended.")

}

fun insertionSort(array: IntArray){
    for (i in 1 until array.size) {
        val currentValue = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > currentValue) {
            array[j + 1] = array[j--]
        }
        array[j + 1] = currentValue
    }
}

fun printArray(array : IntArray){
    for (element in array){
        print("$element ")
    }
}