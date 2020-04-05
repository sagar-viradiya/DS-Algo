package leetcode

/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Note:
        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.

 */
fun main() {
    val nums = intArrayOf(0,1,0,3,12)

    var start = 0
    var numberOfShiftedZeros = 0
    var temp: Int
    while (start < nums.size && start < nums.size - numberOfShiftedZeros - 1) {
        if (nums[start] != 0) {
            start++
            continue
        }
        for (i in start until nums.size - numberOfShiftedZeros - 1) {
            temp = nums[i]
            nums[i] = nums[i+1]
            nums[i+1] = temp
        }
        numberOfShiftedZeros++
    }
    nums.forEach { println(it) }
}