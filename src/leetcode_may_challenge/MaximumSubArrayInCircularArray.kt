package leetcode_may_challenge

/*
    Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

    Here, a circular array means the end of the array connects to the beginning of the array.
    (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

    Also, a subarray may only include each element of the fixed buffer A at most once.
    (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

    Example 1:

    Input: [1,-2,3,-2]
    Output: 3
    Explanation: Subarray [3] has maximum sum 3

    Example 2:

    Input: [5,-3,5]
    Output: 10
    Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

    Example 3:

    Input: [3,-1,2,-1]
    Output: 4
    Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

    Example 4:

    Input: [3,-2,2,-3]
    Output: 3
    Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

    Example 5:

    Input: [-2,-3,-1]
    Output: -1
    Explanation: Subarray [-1] has maximum sum -1

    Note:

        -30000 <= A[i] <= 30000
        1 <= A.length <= 30000

    https://youtu.be/s1CYAnJwf50
 */
fun main() {
    val A = intArrayOf(5, -2, 5)
    if (A.size == 1) {
        print(A[0])
        return
    }
    val sum = A.sum()
    val max = kadaneAlgo(A, 1, A.size)
    if (max < 0) {
        print(max)
    } else {
        print(maxOf(max, sum + kadaneAlgo(A, 1, A.size, -1)))
    }
}

private fun kadaneAlgo(array: IntArray, start: Int, end: Int, sign: Int = 1): Int {
    val dp = IntArray(array.size + 1)
    var temp: Int
    var maxSum = Int.MIN_VALUE
    for (i in start..end) {
        temp = dp[i - 1] + (sign * array[i - 1])
        if (temp > sign * array[i - 1]) {
            dp[i] = temp
        } else {
            dp[i] = sign * array[i - 1]
        }
        maxSum = maxOf(maxSum, dp[i])
    }
    return maxSum
}