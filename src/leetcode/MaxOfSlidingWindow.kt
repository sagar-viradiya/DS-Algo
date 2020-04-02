package leetcode

import java.util.*

/*
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

    Follow up:
    Could you solve it in linear time?

    Example:

    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    Output: [3,3,5,5,6,7]
    Explanation:

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

 */
fun main() {
    val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
    val k = 3
    val maxNumbers = IntArray(nums.size - k + 1)

    //Max priority queue.
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

    for (i in 0 until k) {
        priorityQueue.add(nums[i])
    }
    maxNumbers[0] = priorityQueue.peek()

    for (i in k until nums.size) {
        priorityQueue.remove(nums[i - k])
        priorityQueue.add(nums[i])
        maxNumbers[i - k + 1] = priorityQueue.peek()
    }

    for (maxNumber in maxNumbers) {
        println(maxNumber)
    }
}