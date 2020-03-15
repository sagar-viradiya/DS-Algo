package dailycodingproblem

import kotlin.math.sqrt

/*
    This problem was asked by Uber.

    Write a program that determines the smallest number of perfect squares that sum up to N.

    Here are a few examples:

    Given N = 4, return 1 (4)
    Given N = 17, return 2 (16 + 1)
    Given N = 18, return 2 (9 + 9)
 */
//DP problem.
fun main() {
    val n = 12
    val minimumPerfectSquareSum = IntArray(n+1) { it }

    for (i in 2..n) {
        for (j in sqrt(i.toDouble()).toInt() downTo 1) {
            minimumPerfectSquareSum[i] = minOf(minimumPerfectSquareSum[i], 1 + minimumPerfectSquareSum[i - (j * j)])
        }
    }

    print(minimumPerfectSquareSum[n])
}