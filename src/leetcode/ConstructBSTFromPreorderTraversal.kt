package leetcode

/*
    Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val,
    and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first,
    then traverses node.left, then traverses node.right.)

    Example 1:

    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

            8
          /   \
         5     10
       /  \      \
      1   7      12
 */
fun main() {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val preorder = intArrayOf(8, 5, 1, 7, 10, 12)

    fun constructTree(low: Int, high: Int, preorderTraversal: IntArray): TreeNode {
        if (low == high) return TreeNode(preorderTraversal[low])

        val treeNode = TreeNode(preorderTraversal[low])
        var leftHigh = low
        while (leftHigh < high) {
            if (preorderTraversal[leftHigh + 1] <= preorderTraversal[low]) {
                leftHigh++
                continue
            }
            break
        }
        if (leftHigh != low) {
            treeNode.left = constructTree(low + 1, leftHigh, preorderTraversal)
        }

        if (leftHigh + 1 <= high) {
            treeNode.right = constructTree(leftHigh + 1, high, preorderTraversal)
        }
        return treeNode
    }

    val tree = constructTree(0, preorder.size - 1, preorder)
}

