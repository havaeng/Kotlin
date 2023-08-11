/**
 * An implementation of the QuickSort algorithm with some basic time measurements.
 *
 * Time complexity for QuickSort:
 * Best:    ω(n log(n))
 * Average: θ(n log(n))
 * Worst:   O(n^2) - rare
 * Dividing is lg n, merging is n (linear)
 */

package algorithms

import kotlin.random.Random

fun main(){
    val random = Random
    val size = 100000
    val numbers = IntArray(size)

    //Populate
    for (i in numbers.indices) numbers[i] = random.nextInt(0,size)

    var start: Long = System.currentTimeMillis()
    quickSort(numbers)
    var end: Long = System.currentTimeMillis()
    println("Time lapsed: ${end - start} ms for quicksort.")

    start = System.currentTimeMillis()
    isSortedAscending(numbers)
    end = System.currentTimeMillis()
    println("\n\u001B[0mTime lapsed: ${end - start} ms for ensuring sorted ascended.")
}

fun quickSort(numbers: IntArray) {
    TODO("Not yet implemented")
}
