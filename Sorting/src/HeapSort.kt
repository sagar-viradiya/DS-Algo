/**
 * Heap sort
 *
 * Given an array, sort it in ascending order using heap sort algorithm
 */

fun main(args: Array<String>) {

    val array = intArrayOf(4, 1, 3, 2, 16, 9, 10, 14, 8, 7)

    buildMaxHeap(array)

    for (i in array.size - 1 downTo 1) {
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp
        maxHeapify(array, 0, i - 1)
    }

    for (i in array) {
        print("$i ")
    }

}

private fun buildMaxHeap(array: IntArray) {

    for (i in ((array.size/2) - 1) downTo 0) {
        maxHeapify(array, i)
    }

}

private fun maxHeapify(array: IntArray, rootIndex: Int, heapSize: Int = array.size - 1) {

    val leftChildIndex = (2 * rootIndex) + 1
    val rightChildIndex = (2 * rootIndex) + 2
    var largestElementIndex = rootIndex

    if (leftChildIndex <= heapSize && array[leftChildIndex] > array[rootIndex]) {
        largestElementIndex = leftChildIndex
    }

    if (rightChildIndex <= heapSize && array[rightChildIndex] > array[largestElementIndex]) {
        largestElementIndex = rightChildIndex
    }

    if (largestElementIndex != rootIndex) {
        val temp = array[rootIndex]
        array[rootIndex] = array[largestElementIndex]
        array[largestElementIndex] = temp
        maxHeapify(array, largestElementIndex, heapSize)
    }

}