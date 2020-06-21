package codejam

import java.util.*

/*
    Dr. Patel has N stacks of plates. Each stack contains K plates. Each plate has a positive beauty value,
    describing how beautiful it looks.

    Dr. Patel would like to take exactly P plates to use for dinner tonight. If he would like to take a plate in a stack,
    he must also take all of the plates above it in that stack as well.

    Help Dr. Patel pick the P plates that would maximize the total sum of beauty values.
    Input

    The first line of the input gives the number of test cases, T.
    T test cases follow. Each test case begins with a line containing the three integers N, K and P. Then, N lines follow.
    The i-th line contains K integers, describing the beauty values of each stack of plates from top to bottom.
    Output

    For each test case, output one line containing Case #x: y,
    where x is the test case number (starting from 1) and y is the maximum total sum of beauty values that Dr.
    Patel could pick.
    Limits

    Time limit: 20 seconds per test set.
    Memory limit: 1GB.
    1 ≤ T ≤ 100.
    1 ≤ K ≤ 30.
    1 ≤ P ≤ N * K.
    The beauty values are between 1 and 100, inclusive.
    Test set 1

    1 ≤ N ≤ 3.
    Test set 2

    1 ≤ N ≤ 50.
    Sample

    Input

    2
    2 4 5
    10 10 100 30
    80 50 10 50
    3 2 3
    80 80
    15 50
    20 10

    Output

    Case #1: 250
    Case #2: 180

    In Sample Case #1, Dr. Patel needs to pick P = 5 plates:

        He can pick the top 3 plates from the first stack (10 + 10 + 100 = 120).
        He can pick the top 2 plates from the second stack (80 + 50 = 130) .

    In total, the sum of beauty values is 250.

    In Sample Case #2, Dr. Patel needs to pick P = 3 plates:

        He can pick the top 2 plates from the first stack (80 + 80 = 160).
        He can pick no plates from the second stack.
        He can pick the top plate from the third stack (20).

    In total, the sum of beauty values is 180.
 */
fun main() {
    val scanner = Scanner(System.`in`)

    repeat(scanner.nextInt()) {
        val n = scanner.nextInt()
        val k = scanner.nextInt()
        val p = scanner.nextInt()

        val plateStacks = Array<IntArray>(n) { IntArray(k) }

        repeat(n) { i ->
            repeat(k) { j ->
                plateStacks[i][j] = scanner.nextInt()
            }
        }

        val prefixSum = Array<IntArray>(n + 1) { IntArray(k + 1) }

        repeat(n + 1) { i ->
            if (i > 0) {
                repeat(k + 1) { j ->
                    if (j > 0) {
                        prefixSum[i][j] = prefixSum[i][j - 1] + plateStacks[i - 1][j - 1]
                    }
                }
            }
        }

        val dp = Array<IntArray>(n + 1) { IntArray(p + 1) }
        for (i in 1..n) {
            for (j in 0..p) {
                for (x in 0..minOf(j, k)) {
                    dp[i][j] = maxOf(dp[i][j], prefixSum[i][x] + dp[i - 1][j - x])
                }
            }
        }
        println("Case #${it + 1}: ${dp[n][p]}")
    }
}