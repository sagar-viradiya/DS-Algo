package leetcode

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 0, -1, 0, -2, 2)
    val target = 0

    nums.sort()

    var sum: Int
    var left: Int
    var right: Int

    val result = mutableListOf<List<Int>>()

    for (i in 0..nums.size - 4) {
        if (i != 0 && nums[i] == nums[i -1]) {
            continue
        }
        for (j in i+1..nums.size - 3) {
            if (j != i + 1 && nums[j] == nums[j -1]) {
                continue
            }
            left = j + 1
            right = nums.size - 1
            while (left < right) {
                sum = nums[i] + nums[j] + nums[left] + nums[right]
                when {
                    target == sum -> {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        left++
                        right--
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--
                        }
                    }
                    target < sum -> {
                        right--
                    }
                    else -> {
                        left++
                    }
                }
            }
        }
    }

    print(result)
}