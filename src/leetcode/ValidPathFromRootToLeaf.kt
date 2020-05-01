package leetcode

/*
    Given a binary tree where each path going from the root to any leaf form a valid sequence,
    check if a given string is a valid sequence in such binary tree.

    We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

    Example 1:

                     0
                 /       \
                1          0
             /     \      /
            0       1    0
             \     / \
              1   0   0
    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
    Output: true
    Explanation:
    The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
    Other valid sequences are:
    0 -> 1 -> 1 -> 0
    0 -> 0 -> 0

 */
fun main() {
    class TreeNode(val `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val arr = intArrayOf(0, 1, 0, 1)
    val tree = TreeNode(0).apply {
        left = TreeNode(1).apply {
            left = TreeNode(0).apply {
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            }
        }
        right = TreeNode(0).apply {
            left = TreeNode(0)
        }
    }

    fun isValid(arr: IntArray, node: TreeNode?, position: Int = 0): Boolean {
        if (node == null) {
            return position == arr.size
        }

        if (position == arr.size) return false

        if (position == arr.size - 1) {
            return arr[position] == node.`val` && node.left == null && node.right == null
        }

        return node.`val` == arr[position] &&
                (isValid(arr, node.left, position + 1) || isValid(arr, node.right, position + 1))
    }

    print(isValid(arr, tree))
}