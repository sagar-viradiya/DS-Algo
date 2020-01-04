package dailycodingproblem

/*
    You are given an array of length N, where each element i represents the number of ways we can produce i units of change.
    For example, [1, 0, 1, 1, 2] would indicate that there is only one way to make 0, 2, or 3 units, and two ways of making 4 units.

    Given such an array, determine the denominations that must be in use. In the case above, for example,
    there must be coins with value 2, 3, and 4.
 */
fun main() {
    val input = intArrayOf(1, 0, 1, 0, 2, 1, 3, 1, 3)
    val coins = mutableSetOf<Int>()

    for (i in 1 until input.size) {
        if (input[i] > 0) {
            for (coin in coins) {
                if (input[i - coin] > 0 && (!coins.contains(i - coin) || (i - coin) <= coin)) {
                    input[i] = input[i] - 1
                }
            }
            if (input[i] > 0) {
                coins.add(i)
            }
        }
    }
    print(coins.toString())
}