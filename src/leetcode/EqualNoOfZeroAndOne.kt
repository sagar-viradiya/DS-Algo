package leetcode

/*
    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

    Example 1:

    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

    Example 2:

    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
fun main() {
    val nums = intArrayOf(0, 1, 0)

    val preFixSum = IntArray(nums.size + 1)
    preFixSum[0] = 0
    val indexMap = mutableMapOf<Int, Int>()
    indexMap[0] = 0
    var maxSubArrayLength = 0

    for (i in nums.indices) {
        preFixSum[i + 1] = preFixSum[i] + if (nums[i] == 0) -1 else nums[i]
        if (indexMap[preFixSum[i + 1]] != null) {
            maxSubArrayLength = maxOf(maxSubArrayLength, i - indexMap[preFixSum[i + 1]]!! + 1)
            continue
        }
        indexMap[preFixSum[i + 1]] = i + 1
    }

    print(maxSubArrayLength)
}