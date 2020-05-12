package leetcode_may_challenge

/*
    You are given a sorted array consisting of only integers where every element appears exactly twice,
    except for one element which appears exactly once. Find this single element that appears only once.

    Example 1:

    Input: [1,1,2,3,3,4,4,8,8]
    Output: 2

    Example 2:

    Input: [3,3,7,7,10,11,11]
    Output: 10

    Note: Your solution should run in O(log n) time and O(1) space.

 */
fun main() {
    val nums = intArrayOf(3, 3, 2, 2, 1)

    var left = 0
    var right = nums.size - 1
    var mid: Int
    while (left < right) {
        mid = left + (right - left) / 2
        if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
            print(nums[mid])
            return
        }
        if (nums[mid - 1] == nums[mid]) {
            if ((mid - 1 - left) % 2 != 0) {
                right = mid - 2
            } else {
                left = mid + 1
            }
        }

        if (nums[mid + 1] == nums[mid]) {
            if ((right - mid + 1) % 2 != 0) {
                left = mid + 2
            } else {
                right = mid - 1
            }
        }
    }
    print(nums[left])
}