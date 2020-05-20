package leetcode_may_challenge

/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    Output: 1

    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3

    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
    How would you optimize the kthSmallest routine?

 */

var k = 3

fun main() {
    class TreeNode(val `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val tree = TreeNode(5).apply {
        left = TreeNode(3)
        right = TreeNode(8).apply {
            left = TreeNode(7).apply {
                left = TreeNode(6)
            }
            right = TreeNode(9)
        }
    }

    fun inOrderTraversal(node: TreeNode): Int {
        if (node.left == null && node.right == null) {
            k--
            return node.`val`
        }
        var value = node.left?.let {
            inOrderTraversal(it)
        }
        if (value != null && k == 0) return value
        if (--k == 0) return node.`val`
        value = node.right?.let {
            inOrderTraversal(it)
        }
        if (value != null && k == 0) return value
        return Int.MIN_VALUE
    }

    print(inOrderTraversal(tree))
}