package dynamicprogramming

/*
    Say you have an array for which the ith element
    is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction
    (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.
    Example 1:
    Input: [7, 1, 5, 3, 6, 4]
    Output: 5
    max. difference = 6-1 = 5
    (not 7-1 = 6, as selling price needs to be larger than buying price)
    Example 2:
    Input: [7, 6, 4, 3, 1]
    Output: 0
    In this case, no transaction is done, i.e. max profit = 0.
*/

fun main(args: Array<String>) {
    val stockPrice = intArrayOf(100, 180, 260, 310, 40, 535, 695)
    val caching = Array(stockPrice.size) { IntArray(stockPrice.size) { -1 } }
    print(maximizeProfit(0, stockPrice.size - 1, stockPrice, caching))
    print(maximizeProfit(stockPrice))
}

private fun maximizeProfit(i: Int, j: Int, stockPrice: IntArray, caching: Array<IntArray>): Int {

    return if (i == j) 0
    else if (caching[i][j] > -1) caching[i][j]
    else if (i == j-1) {
        if (stockPrice[j] - stockPrice[i] < 0) 0 else stockPrice[j] - stockPrice[i]
    } else {
        caching[i][j] = maxOf(stockPrice[j] - stockPrice[i],
                maximizeProfit(i, j-1, stockPrice, caching),
                maximizeProfit(i+1, j, stockPrice, caching))
        caching[i][j]
    }
}

//O(n)
private fun maximizeProfit(stockPrice: IntArray): Int {

    var currentMax = 0
    var maxSoFar = 0

    for (i in 1 until stockPrice.size) {
        currentMax = maxOf(0, currentMax + stockPrice[i] - stockPrice[i -1])
        maxSoFar = maxOf(maxSoFar, currentMax)
    }

    return maxSoFar
}