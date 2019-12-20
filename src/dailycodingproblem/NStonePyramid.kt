package dailycodingproblem

/*
    You have N stones in a row, and would like to create from them a pyramid.
    This pyramid should be constructed such that the height of each stone increases by one until reaching the tallest stone,
    after which the heights decrease by one. In addition, the start and end stones of the pyramid should each be one stone high.

    You can change the height of any stone by paying a cost of 1 unit to lower its height by 1,
    as many times as necessary. Given this information, determine the lowest cost method to produce this pyramid.

    For example, given the stones [1, 1, 3, 3, 2, 1], the optimal solution is to pay 2 to create [0, 1, 2, 3, 2, 1].
 */
fun main() {
    val input = intArrayOf(1, 1, 3, 3, 2, 1)

    val caching = Array<IntArray>(input.size) {
        IntArray(input.size) { -1 }
    }

    print(cost(input, caching, 0, input.size - 1))

}

private fun cost(input: IntArray, caching: Array<IntArray>, startIndex: Int, endIndex: Int): Int {
    if (caching[startIndex][endIndex] != -1) return caching[startIndex][endIndex]
    if (startIndex == endIndex) return 0
    if ((endIndex - startIndex) % 2 != 0) {
        caching[startIndex][endIndex] = minOf(input[startIndex] + cost(input, caching, startIndex + 1, endIndex),
                input[endIndex] + cost(input, caching, startIndex, endIndex - 1))
        return caching[startIndex][endIndex]
    } else {
        val mid = (startIndex + endIndex) / 2
        var tempStartIndex = mid
        var tempEndIndex = mid

        var moveLeft = true
        var moveRight = true

        while (moveLeft || moveRight) {
            if (moveRight) {
                if (tempEndIndex == endIndex || input[tempEndIndex] == 1) {
                    moveRight = false
                } else {
                    tempEndIndex++
                }
            }
            if (moveLeft) {
                if (tempStartIndex == startIndex || input[tempStartIndex] == 1 || input[tempStartIndex] < input[tempStartIndex - 1]) {
                    moveLeft = false
                } else {
                    tempStartIndex--
                }
            }
        }

        var additionalCost = 0
        for (i in startIndex until tempStartIndex) {
            additionalCost += input[i]
        }
        for (j in endIndex downTo tempEndIndex + 1) {
            additionalCost += input[j]
        }

        caching[startIndex][endIndex] = if ((tempEndIndex - tempStartIndex) % 2 == 0) {
            var diffFactor = 1
            val tempMid = (tempStartIndex + tempEndIndex) / 2
            var cost = 0
            for (i in tempStartIndex..tempEndIndex) {
                cost += if (i < tempMid) {
                    input[i] - diffFactor++
                } else if (i == tempMid) {
                    input[i] - diffFactor
                } else {
                    input[i] - (--diffFactor)
                }
            }
            additionalCost + cost
        } else {
            additionalCost + cost(input, caching, tempStartIndex, tempEndIndex)
        }
        return caching[startIndex][endIndex]
    }
}

