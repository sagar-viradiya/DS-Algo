package leetcode_may_challenge

/*
    In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:

        The town judge trusts nobody.
        Everybody (except for the town judge) trusts the town judge.
        There is exactly one person that satisfies properties 1 and 2.

    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */

fun main() {
    val n = 4
    val trust = arrayOf(Pair(1, 3), Pair(1, 4), Pair(2, 3), Pair(2, 4), Pair(4, 3))

    if (n == 1 && trust.isEmpty()) {
        print(n)
        return
    }

    val inBoundMap = mutableMapOf<Int, MutableList<Int>>()
    val outBoundMap = mutableMapOf<Int, MutableList<Int>>()
    var sum = 0
    for (pair in trust) {
        if (inBoundMap.containsKey(pair.second)) {
            inBoundMap[pair.second]!!.add(pair.first)
        } else {
            inBoundMap[pair.second] = mutableListOf(pair.first)
        }

        if (outBoundMap.containsKey(pair.first)) {
            outBoundMap[pair.first]!!.add(pair.second)
        } else {
            sum += pair.first
            outBoundMap[pair.first] = mutableListOf(pair.second)
        }
    }

    if (sum == (n * (n + 1)) / 2) {
        print(-1)
        return
    }
    if (inBoundMap[((n * (n + 1) / 2)) - sum]?.size == n - 1) {
        print((n * (n + 1) / 2) - sum)
        return
    }
    print(-1)
}