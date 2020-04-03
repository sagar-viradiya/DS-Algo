package dailycodingproblem

/*
    You are given coins of different denominations and a total amount of money amount.
    Write a function to compute the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:

    Input: coins = [1, 2, 5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Example 2:

    Input: coins = [2], amount = 3
    Output: -1

 */
fun main() {
    val coins = intArrayOf(2)
    val amount = 3
    print(getMinimumCoins(amount,coins,IntArray(amount)))
}

fun getMinimumCoins(amount: Int, coins: IntArray, cache: IntArray): Int {
    if (amount < 0) return -1
    if (amount == 0) return 0
    if (cache[amount - 1] != 0) return cache[amount - 1]
    var min = Int.MAX_VALUE
    for (i in coins.indices) {
        val minCoins = getMinimumCoins(amount - coins[i], coins, cache)
        if (minCoins > -1) {
            min = minOf(min,  minCoins + 1)
        }
    }
    if (min == Int.MAX_VALUE) {
        cache[amount - 1] = -1
    } else {
        cache[amount - 1] = min
    }
    return cache[amount - 1]
}

