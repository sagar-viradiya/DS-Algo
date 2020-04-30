package leetcode

/*
    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
    The path must contain at least one node and does not need to go through the root.

    Example 1:

    Input: [1,2,3]

           1
          / \
         2   3

    Output: 6

    Example 2:

    Input: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

    Output: 42

 */
fun main() {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val tree = TreeNode(10).apply {
        left = TreeNode(15).apply {
            left = TreeNode(21).apply {
                left = TreeNode(7)
                right = TreeNode(1)
            }
            right = TreeNode(70)
        }
        right = TreeNode(11).apply {
            left = TreeNode(2).apply {
                left = TreeNode(7)
                right = TreeNode(15)
            }
            right = TreeNode(1)
        }
    }

    var maximumSoFar = Int.MIN_VALUE

    fun calculateMaximumPathSum(node: TreeNode?): Int {
        if (node == null) return 0
        val leftSum = calculateMaximumPathSum(node.left)
        val rightSum = calculateMaximumPathSum(node.right)
        maximumSoFar = maxOf(maximumSoFar, leftSum + rightSum + node.`val`)
        return maxOf(0, node.`val` + maxOf(leftSum, rightSum)) // If sum is -ve return 0 as we don't count it in the path.
    }
    calculateMaximumPathSum(tree)
    print(maximumSoFar)
}