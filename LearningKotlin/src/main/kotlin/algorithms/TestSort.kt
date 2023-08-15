package algorithms

import kotlin.random.Random

fun main(){
    val random = Random
    val size = 100000
    val numbers = IntArray(size)

    val mergeSorter = MergeSort()
    val insertionSorter = InsertionSort()
    val quickSorter = QuickSort()

    //Populate
    for (i in numbers.indices) numbers[i] = random.nextInt(0,size)

    var start: Long = System.currentTimeMillis()
    mergeSorter.sort(numbers)
    //quickSorter.sort(numbers)
    //insertionSorter.sort(numbers)
    var end: Long = System.currentTimeMillis()
    println("Time lapsed: ${end - start}ms.")

    start = System.currentTimeMillis()
    isSortedAscending(numbers)
    end = System.currentTimeMillis()
    println("\n\u001B[0mTime lapsed: ${end - start} ms for ensuring sorted ascended.")
}

fun isSortedAscending(array: IntArray) {
    for (i in 1 until array.size) {
        if (array[i] < array[i - 1]) {
            println("\u001B[31mArray is not sorted.")
        }
    }
    println("\n\u001B[32mArray is sorted.")
}
