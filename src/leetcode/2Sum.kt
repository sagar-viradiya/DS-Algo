package leetcode

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(2, 5, 5, 11)
    val target = 10

    val map = mutableMapOf<Int, Int>()

    for (i in 0 until nums.size) {
        if (map[target - nums[i]] != null) {
            print("$i, ${map[target - nums[i]]}")
            break
        }
        map[nums[i]] = i
    }

}