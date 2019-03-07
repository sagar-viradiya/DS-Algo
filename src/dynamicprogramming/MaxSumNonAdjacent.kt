package dynamicprogramming

import java.lang.IllegalStateException

/*
    This problem was asked by Airbnb.

    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
*/

fun main(args: Array<String>) {
    val input = intArrayOf(5, -1, -1, -1, 5)
    print(getMaxSum(input))
}

private fun getMaxSum(array: IntArray): Int {
    for (i in 1 until array.size) {
        array[i] = if (i == 1) {
            maxOf(array[i - 1], array[i])
        } else {
            maxOf(array[i - 1], array[i] + array[i - 2])
        }
    }
    return if (array.isEmpty()) throw IllegalStateException("Array is empty, go freak out !!!") else array.last()
}