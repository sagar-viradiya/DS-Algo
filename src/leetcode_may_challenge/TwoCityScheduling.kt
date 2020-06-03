package leetcode_may_challenge

/*
    There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
    and the cost of flying the i-th person to city B is costs[i][1].

    Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

    Example 1:

    Input: [[10,20],[30,200],[400,50],[30,20]]
    Output: 110
    Explanation:
    The first person goes to city A for a cost of 10.
    The second person goes to city A for a cost of 30.
    The third person goes to city B for a cost of 50.
    The fourth person goes to city B for a cost of 20.

    The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

    Note:

        1 <= costs.length <= 100
        It is guaranteed that costs.length is even.
        1 <= costs[i][0], costs[i][1] <= 1000

 */
fun main() {
    val costs = arrayOf(intArrayOf(10, 20), intArrayOf(30, 200), intArrayOf(400, 50), intArrayOf(30, 20))

    // Sort by diff between City A and City B
    costs.sortWith(Comparator<IntArray> { cost1, cost2 ->
        val diff1 = cost1[0] - cost1[1]
        val diff2 = cost2[0] - cost2[1]
        when {
            diff1 > diff2 -> 1
            diff1 < diff2 -> -1
            else -> 0
        }
    })

    var minimumCost = 0

    // Choose city A for first N since diff A - B would be smallest and hence B would be largest. Choose city B for remaining.
    for (i in costs.indices) {
        minimumCost += if (i < costs.size / 2) {
            costs[i][0]
        } else {
            costs[i][1]
        }
    }
    print(minimumCost)
}