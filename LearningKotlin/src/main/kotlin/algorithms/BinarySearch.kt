package algorithms

import kotlin.random.Random
fun main(){
    val size = 10000
    val target = 9999
    //Ordered data structure with constant - O(1) - access time
    val vector = populateAndSort(size)

    val start = System.currentTimeMillis()
    val result = binarySearch(vector, target, 0, vector.size - 1)
    val end = System.currentTimeMillis()
    val timeLapsed = end - start

    if (result == -1){
        println("\u001B[31mTarget $target not found in array. \u001B[0mArray size was $size. Time elapsed: $timeLapsed ms.")
    } else
    println("\u001B[32mTarget $target found at index $result. \u001B[0mArray size was $size. Time elapsed: $timeLapsed ms.")
}

fun binarySearch(sortedVector: ArrayList<Int>, target : Int, low : Int, high : Int) : Int {
    println("Recursive call made")
    val middle = low + ((high - low) / 2)
    //Exit condition. If true - not done yet!
    if (high > low) {

        if (target < sortedVector[low] || target > sortedVector[high]) return -1 // Target is outside range
        if (target == sortedVector[middle]) return middle //Bullseye
        else if (target < sortedVector[middle]) {
            return binarySearch(sortedVector, target, low, middle - 1)
        } else {
            return binarySearch(sortedVector, target, middle + 1, high)
        }
    }
    return -1
}

fun populateAndSort(size : Int) : ArrayList<Int> {
    val vector = ArrayList<Int>()
    val random = Random
    for (i in 0 until size){
        vector.add(random.nextInt(0, size + 1))
    }
    vector.sort()
    return vector
}

