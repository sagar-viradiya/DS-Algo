package dynamicprogramming

fun main(args: Array<String>) {

    //Change this to test diff use cases
    val input = intArrayOf(1, 2, 3)
    val changeOf = 4

    val combination = LongArray(changeOf + 1)
    combination[0] = 1

    for (coin in input) {
        for (i in 1 until combination.size) {
            if (i >= coin) {
                combination[i] += combination[(i-coin)]
            }
        }
    }

    print(combination[changeOf])
}