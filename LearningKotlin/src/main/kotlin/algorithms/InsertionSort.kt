/**
 * An implementation of the InsertionSort algorithm with some basic time measurements.
 *
 * Time complexity for InsertionSort:
 * Worst:   O(n^2) ("reverse" sorted)
 * Average: θ(n^2)
 * Best:    ω(n) (already sorted, small n values, etc)
 */

package algorithms

class InsertionSort : Sorter {
    override fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            val currentValue = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j--]
            }
            array[j + 1] = currentValue
        }
    }
}