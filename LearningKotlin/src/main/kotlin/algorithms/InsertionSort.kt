/**
 * An implementation of the InsertionSort algorithm with some basic time measurements.
 *
 * Time complexity for InsertionSort:
 * Worst:   O(n^2)  - "reverse" sorted
 * Average: θ(n^2)
 * Best:    ω(n)    - already sorted, small n values, etc
 */

package algorithms

class InsertionSort : Sorter {
    override fun sort(inputArray: IntArray) {
        for (i in 1 until inputArray.size) {
            val currentValue = inputArray[i]
            var j = i - 1
            while (j >= 0 && inputArray[j] > currentValue) {
                inputArray[j + 1] = inputArray[j--]
            }
            inputArray[j + 1] = currentValue
        }
    }
}