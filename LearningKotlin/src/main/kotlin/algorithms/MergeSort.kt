/**
 * An implementation of the MergeSort algorithm with some basic time measurements.
 *
 * Time complexity for MergeSort:
 * Best: n log(n)
 * Average: n log(n)
 * Worst: n log(n)
 */

package algorithms

import kotlin.random.Random

fun main(){
    val random = Random
    val size = 100000
    val numbers = IntArray(size)

    for (i in numbers.indices) numbers[i] = random.nextInt(0,size)

    var start: Long = System.currentTimeMillis()
    mergeSort(numbers)
    var end: Long = System.currentTimeMillis()
    println("Time lapsed: ${end - start} ms for mergesort.")

    start = System.currentTimeMillis()
    isSortedAscending(numbers)
    end = System.currentTimeMillis()
    println("\n\u001B[0mTime lapsed: ${end - start} ms for ensuring sorted ascended.")
}

fun mergeSort(inputArray: IntArray){
    val inputLength = inputArray.size

    //Exit condition: are we done dividing?
    if (inputLength < 2) return

    val midIndex = inputLength / 2
    val leftHalf = IntArray(midIndex)
    val rightHalf = IntArray(inputLength - midIndex) //To account for arrays with odd numbers

    for (i in 0 until midIndex) {
        leftHalf[i] = inputArray[i]
    }

    for (i in midIndex until inputLength) {
        rightHalf[i - midIndex] = inputArray[i]
    }

    //Continue dividing
    mergeSort(leftHalf)
    mergeSort(rightHalf)

    //Dividing done, insert halves into original array
    merge(inputArray, leftHalf, rightHalf)
}

fun merge(inputArray: IntArray, leftHalf : IntArray, rightHalf : IntArray){
    val leftSize = leftHalf.size
    val rightSize = rightHalf.size

    var leftIterator = 0 //i
    var rightIterator = 0 //j
    var inputArrayIterator = 0 //k

    while (leftIterator < leftSize && rightIterator < rightSize){
        if (leftHalf[leftIterator] <= rightHalf[rightIterator]){
            inputArray[inputArrayIterator] = leftHalf[leftIterator]
            leftIterator++
        } else {
            inputArray[inputArrayIterator] = rightHalf[rightIterator]
            rightIterator++
        }
        inputArrayIterator++
    }
    //Add trailing elements
    while (leftIterator < leftSize) {
        inputArray[inputArrayIterator] = leftHalf[leftIterator]
        leftIterator++
        inputArrayIterator++
    }
    while (rightIterator < rightSize) {
        inputArray[inputArrayIterator] = rightHalf[rightIterator]
        rightIterator++
        inputArrayIterator++
    }
}

fun isSortedAscending(array: IntArray): Boolean {
    for (i in 1 until array.size) {
        if (array[i] < array[i - 1]) {
            println("\u001B[31mArray is not sorted.")
            return false
        }
    }
    println("\n\u001B[32mArray is sorted.")
    return true
}
