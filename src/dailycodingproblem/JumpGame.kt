package dailycodingproblem

/*
    You are given an array of nonnegative integers. Let's say you start at the beginning of the array and are trying to
    advance to the end. You can advance at most, the number of steps that you're currently on. Determine whether you can
    get to the end of the array.

    For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.

    Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
 */

fun main() {
    val nums = intArrayOf(1, 3, 1, 2, 0, 1)
    val result = IntArray(nums.size)
    result[nums.size - 1] = 1
    for (i in nums.size - 2 downTo 0) {
        if (nums[i] == 0) {
            result[i] = 0
        } else {
            if (i + nums[i] > nums.size - 1) {
                for (j in i + 1 until nums.size) {
                    if (result[j] == 1) {
                        result[i] = 1
                        break
                    }
                }
            } else {
                for (j in i + 1..i + nums[i]) {
                    if (result[j] == 1) {
                        result[i] = 1
                        break
                    }
                }
            }
        }
    }

    if (result[0] == 1) {
        println("True")
    } else {
        println("False")
    }
}