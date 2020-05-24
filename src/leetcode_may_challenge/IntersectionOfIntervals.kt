package leetcode_may_challenge

/*
    Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

    Return the intersection of these two interval lists.

    (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
    The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
    For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

    Example 1:

    Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.

    Note:

        0 <= A.length < 1000
        0 <= B.length < 1000
        0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

    https://youtu.be/d8Gy8Dkvfj8
 */
fun main() {
    val ans = mutableListOf<IntArray>()

    val A = arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25))
    val B = arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))

    var i = 0
    var j = 0
    var maxOfLeft: Int
    var minOfRight: Int
    while (i < A.size && j < B.size) {
        maxOfLeft = maxOf(A[i][0], B[j][0])
        minOfRight = minOf(A[i][1], B[j][1])

        if (maxOfLeft <= minOfRight) {
            ans.add(intArrayOf(maxOfLeft, minOfRight))
        }

        if (A[i][1] < B[j][1]) {
            i++
        } else {
            j++
        }
    }

    ans.forEach {
        for (i in it) {
            print("$i ")
        }
        println()
    }
}