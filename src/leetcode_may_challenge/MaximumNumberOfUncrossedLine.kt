package leetcode_may_challenge

/*
    We write the integers of A and B (in the order they are given) on two separate horizontal lines.

    Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

        A[i] == B[j];
        The line we draw does not intersect any other connecting (non-horizontal) line.

    Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

    Return the maximum number of connecting lines we can draw in this way.

    Example 1:

    1 2 1
     / /
    2 1
    Input: A = [1,2,1], B = [2,1]
    Output: 2

    Example 2:

    Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
    Output: 3

    Example 3:

    Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
    Output: 2

    Note:

        1 <= A.length <= 500
        1 <= B.length <= 500
        1 <= A[i], B[i] <= 2000

 */
fun main() {
    val A = intArrayOf(1, 2, 1)
    val B = intArrayOf(2, 1)

    val dp = Array<IntArray>(A.size + 1) {
        IntArray(B.size + 1)
    }
    for (i in 1..A.size) {
        for (j in 1..B.size) {
            if (A[i - 1] == B[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    print(dp[A.size][B.size])
}