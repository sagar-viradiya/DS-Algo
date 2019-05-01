package dynamicprogramming

/*
 Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

 For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up
 into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

 Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add
 up to the same sum.
*/

fun main(args: Array<String>) {
    val array = intArrayOf(1, 5, 3, 5)
    val sum = array.sum()
    if (sum % 2 == 0) {
        println(canBeSplittable(array.size - 1, sum/2, array))
    } else {
        println(false)
    }
}

private fun canBeSplittable(endIndex: Int, sum: Int, array: IntArray): Boolean {
    return when {
        endIndex == 0 -> sum == array[endIndex]
        array[endIndex] == sum -> true
        else -> {
            (array[endIndex] < sum && canBeSplittable(endIndex - 1, sum - array[endIndex], array)) ||
                    canBeSplittable(endIndex - 1, sum, array)
        }
    }
}