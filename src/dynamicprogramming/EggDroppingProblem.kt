package dynamicprogramming

/*
    The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.

    Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the
    eggs to break on landing. We make a few assumptions:

        - An egg that survives a fall can be used again.
        - A broken egg must be discarded.
        - The effect of a fall is the same for all eggs.
        - If an egg breaks when dropped, then it would break if dropped from a higher floor.
        - If an egg survives a fall then it would survive a shorter fall.
        - It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause
          an egg to break.

    If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out
    in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window.
    Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available.
    What is the least number of egg-droppings that is guaranteed to work in all cases?
    The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be
    dropped so that total number of trials are minimized.
*/

fun main(args: Array<String>) {

    val k = 2
    val n = 36

    val caching = Array(k + 1) { IntArray(n +  1) { -1 } }
    println(dropEgg(k, n, caching))
    print(dropEgg(k, n))
}

//Dynamic programming
private fun dropEgg(k: Int, n: Int, caching: Array<IntArray>): Int {

    if (n == 0 || n == 1 || k == 1) {
        return n
    }

    if (caching[k][n] > -1) {
        return caching[k][n]
    }

    var min = Int.MAX_VALUE
    var res: Int

    for (i in 1..n) {
        res = maxOf(dropEgg(k-1, i-1, caching), dropEgg(k, n-i, caching))
        if (min > res) {
            min = res
        }
    }

    caching[k][n] = min + 1

    return min + 1

}

//Bottom up approach
private fun dropEgg(k: Int, n: Int): Int {

    val caching = Array(k + 1) { IntArray(n +  1) { 0 } }
    var res: Int

    for (j in 1..k) {
        caching[j][1] = 1
    }

    for (i in 1..n) {
        caching[1][i] = i
    }

    for (i in 2..k) {
        for (j in 2..n) {
            caching[i][j] = Int.MAX_VALUE
            for (k in 1..j) {
                res = 1 + maxOf(caching[i - 1][k - 1], caching[i][j - k])
                if (res < caching[i][j]) {
                    caching[i][j] = res
                }
            }
        }
    }

    return caching[k][n]

}