/**
 * An implementation of the MergeSort algorithm.
 *
 * Time complexity for MergeSort:
 * Worst:   O(n log(n))
 * Average: θ(n log(n))
 * Best:    ω(n log(n))
 *
 * Dividing is lg n, merging is n (linear)
 */

package algorithms

class MergeSort : Sorter {
    override fun sort(inputArray: IntArray){
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
        sort(leftHalf)
        sort(rightHalf)

        //Dividing done, insert halves into original array
        merge(inputArray, leftHalf, rightHalf)
    }

    private fun merge(inputArray: IntArray, leftHalf : IntArray, rightHalf : IntArray){
        val leftSize = leftHalf.size
        val rightSize = rightHalf.size

        var leftIterator = 0
        var rightIterator = 0
        var inputArrayIterator = 0

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
}

