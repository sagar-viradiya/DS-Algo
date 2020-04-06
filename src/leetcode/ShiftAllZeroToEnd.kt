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

    var nxt = 0

    for (num in nums) {
        if (num != 0) {
            nums[nxt] = num
            nxt++
        }
    }

    for (i in nxt until nums.size) {
        nums[i] = 0
    }
    nums.forEach { println(it) }
}