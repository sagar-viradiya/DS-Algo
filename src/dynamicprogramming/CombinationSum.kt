package dynamicprogramming

/*
    Given an integer array with all positive numbers and no duplicates,
    find the number of possible combinations that
    add up to a positive integer target.
    Example:
    nums = [1, 2, 3]
    target = 4
    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)
    Note that different sequences are counted as different combinations.
    Therefore the output is 7.
*/

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3)
    val target = 4
    val caching = IntArray(target + 1) { -1 }
    caching[0] = 1
    print(combinationSum(nums, target, caching))
}

private fun combinationSum(nums: IntArray, target: Int, caching: IntArray): Int {

    if (caching[target] != -1) {
        return caching[target]
    }

    var temp = 0

    for (i in 0 until nums.size) {
        if (target >= nums[i]) {
            temp += combinationSum(nums, target - nums[i], caching)
        }
    }

    caching[target] = temp

    return temp

}

