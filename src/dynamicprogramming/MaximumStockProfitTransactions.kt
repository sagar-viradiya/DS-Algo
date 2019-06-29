package dynamicprogramming

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

solution video - https://youtu.be/Pw6lrYANjz4
 */
// Time - O(kn) Space - O(n)
fun main(args: Array<String>) {

    val prices = intArrayOf(5, 2, 4, 0, 1)
    val k = 2

    val oddProfits = IntArray(prices.size)
    val evenProfits = IntArray(prices.size)
    var currentProfits = evenProfits
    var previousProfits: IntArray

    var max: Int

    for (i in 1..k) {
        max = -prices[0]
        if (i % 2 == 0) {
            currentProfits = evenProfits
            previousProfits = oddProfits
        } else {
            currentProfits = oddProfits
            previousProfits = evenProfits
        }
        for (j in 1 until prices.size) {
            currentProfits[j] = maxOf(currentProfits[j-1], prices[j] + max)
            max = maxOf(max, -prices[j] + previousProfits[j])
        }
    }

    print(currentProfits[prices.size-1])

}

