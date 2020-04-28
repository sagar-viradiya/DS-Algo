package leetcode

/*
    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Example:

    Input:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

    Output: 4
 */
fun main() {
    val matrix = arrayOf(charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0'))

    var max = 0
    val dp = Array(matrix.size + 1) {
        IntArray(matrix[0].size + 1)
    }

    for (i in 1..matrix.size) {
        for (j in 1..matrix[0].size) {
            if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = minOf(dp[i][j -1], dp[i - 1][j - 1], dp[i - 1][j]) + 1
            }
            max = maxOf(max, dp[i][j])
        }
    }

    print(max*max)
}