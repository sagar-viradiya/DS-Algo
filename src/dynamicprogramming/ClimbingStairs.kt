package dynamicprogramming

/*
    You are climbing a stair case.
    It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps.
    In how many distinct ways can you climb to the top?
    Note: Given n will be a positive integer.
*/

fun main(args: Array<String>) {
    println(climbStairs(10, IntArray(10)))
    print(climbStairs(10))
}

private fun climbStairs(numOfStairs: Int, caching: IntArray): Int {

    return when {
        numOfStairs == 1 -> 1
        numOfStairs == 2 -> 2
        caching[numOfStairs - 1] != 0 -> caching[numOfStairs - 1]
        else -> {
            caching[numOfStairs - 1] = climbStairs(numOfStairs - 1, caching) +
                    climbStairs(numOfStairs - 2, caching)
            caching[numOfStairs - 1]
        }
    }

}

//Bottom up approach
private fun climbStairs(numOfStairs: Int): Int {

    val stairsAnswer = IntArray(numOfStairs + 1)
    stairsAnswer[0] = 0
    stairsAnswer[1] = 1
    stairsAnswer[2] = 2

    return when (numOfStairs) {
        1, 2 -> numOfStairs
        else -> {
            for (i in 3..numOfStairs) {
                stairsAnswer[i] = stairsAnswer[i - 1] + stairsAnswer[i - 2]
            }
            stairsAnswer[numOfStairs]
        }
    }

}

