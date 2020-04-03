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
    val coins = intArrayOf(1, 2, 5)
    val amount = 11
    print(getMinimumCoins(amount,coins))
}

//Top down DP
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

//Bottom Up DP
fun getMinimumCoins(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1) { if (it == 0) 0 else amount + 1 }

    for (i in 1 until amount + 1) {
        for (j in coins.indices) {
            if (coins[j] <= i) {
                dp[i] = minOf(dp[i], dp[i - coins[j]] + 1)
            }
        }
    }

    return if (dp[amount] > amount) {
        -1
    } else {
        dp[amount]
    }
}

