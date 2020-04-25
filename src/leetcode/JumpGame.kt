package leetcode

/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    Example 1:

    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:

    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
 */
fun main() {
    val nums = intArrayOf(2, 7, 1, 1, 4)
    print(depthFirstSearch(0, nums, IntArray(nums.size) { if (it == nums.size - 1) 1 else -1 }))
}

private fun depthFirstSearch(start: Int, nums: IntArray, dp: IntArray): Boolean {
    if (dp[start] != -1) return dp[start] == 1

    if (nums.size - 1 - nums[start] - start == 0) {
        dp[start] = 1
        return true
    }

    repeat(minOf(start + nums[start], nums.size - 1) - start) {
        if (depthFirstSearch(start + it + 1, nums, dp)) {
            dp[start] = 1
            return true
        }
    }

    dp[start] = 0
    return false
}