package dailycodingproblem

import kotlin.math.sqrt

/*
    Given a positive integer N, find the smallest number of steps it will take to reach 1.

    There are two kinds of permitted steps:

    You may decrement N to N - 1.
    If a * b = N, you may decrement N to the larger of a and b.
    For example, given 100, you can reach 1 in five steps with the following route: 100 -> 10 -> 9 -> 3 -> 2 -> 1.
 */
fun main() {
    val input = 90

    //Bottom up approach
    val cache = IntArray(input + 1) { it - 1 }
    for (i in 1 until cache.size) {
        for (j in 1..sqrt(i.toDouble()).toInt()) {
            if (i % j == 0) {
                cache[i] = minOf(cache[i], cache[i / j] + 1)
            }
        }
        cache[i] = minOf(cache[i], cache[i - 1] + 1)
    }
    print(cache[input])
}
