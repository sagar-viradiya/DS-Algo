package leetcode

/*
     Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

    Construct the maximum tree by the given array and output the root node of this tree.

    Example 1:

    Input: [3,2,1,6,0,5]
    Output: return the tree root node representing the following tree:

          6
        /   \
       3     5
        \    /
         2  0
           \
            1

    Note:
    The size of the given array will be in the range [1,1000].

 */

fun main() {
    val nums = intArrayOf(3, 2, 1, 6, 0, 5)

    class TreeNode(val `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maximumIndex(startIndex: Int, endIndex: Int, nums: IntArray): Int {
        var max = nums[startIndex]
        var index = startIndex
        for (i in startIndex + 1..endIndex) {
            if (max < nums[i]) {
                max = nums[i]
                index = i
            }
        }
        return index
    }

    fun constructTree(startIndex: Int, endIndex: Int, nums: IntArray): TreeNode? {
        if (startIndex > endIndex) return null
        if (startIndex == endIndex) return TreeNode(nums[startIndex])
        val maxIndex = maximumIndex(startIndex, endIndex, nums)
        return TreeNode(nums[maxIndex]).apply {
            left = constructTree(startIndex, maxIndex - 1, nums)
            right = constructTree(maxIndex + 1, endIndex, nums)
        }
    }

    val tree = constructTree(0, nums.size - 1, nums)
}

