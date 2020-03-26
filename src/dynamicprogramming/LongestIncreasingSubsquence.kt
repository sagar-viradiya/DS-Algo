package dynamicprogramming

/*
    Given an unsorted array of integers, find the length of longest increasing subsequence.

    Example:

    Input: [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

fun main() {
    val input = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18, 19, 20, 21)
    val cacheLIS = IntArray(input.size) { 1 }

    for (i in input.indices) {
        for (j in 0 until i) {
            if (input[i] > input[j]) {
                cacheLIS[i] = maxOf(cacheLIS[j] + 1, cacheLIS[i])
            }
        }
    }
    print(cacheLIS.max())
}