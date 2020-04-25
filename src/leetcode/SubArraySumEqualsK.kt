package leetcode

/*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:

    Input:nums = [1,1,1], k = 2
    Output: 2

 */
//O(n) and extra space complexity
fun main() {
    val nums = intArrayOf(1)
    val k = 0

    val sumFreq = mutableMapOf(0 to 1)

    var sum = 0
    var numOfArrays = 0

    repeat(nums.size) {
        sum += nums[it]
        if (sumFreq[sum - k] != null) {
            numOfArrays += sumFreq[sum - k]!!
        }
        if (sumFreq[sum] == null) {
            sumFreq[sum] = 1
        } else {
            sumFreq[sum] = sumFreq[sum]!! + 1
        }
    }
    print(numOfArrays)
}