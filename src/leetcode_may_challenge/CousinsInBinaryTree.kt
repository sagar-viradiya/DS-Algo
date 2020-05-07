package leetcode_may_challenge

import java.util.*

/*
    In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

    Return true if and only if the nodes corresponding to the values x and y are cousins.

    Example 1:

        1
       / \
      2   3
     /
    4

    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

    Example 2:

         1
       /   \
      2     3
       \     \
        4     5

    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

    Example 3:

         1
       /   \
      2     3
       \
        4

    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false

 */
fun main() {
    class TreeNode(val `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val tree = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }

    fun levelOrderTraversal(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null) return false

        val queue = LinkedList<Pair<TreeNode, TreeNode?>>()
        queue.add(Pair(root, null))
        var temp: Pair<TreeNode, TreeNode?>
        var nodeXPair: Pair<TreeNode, TreeNode?>? = null
        var nodeYPair: Pair<TreeNode, TreeNode?>? = null
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                temp = queue.pop()
                if (temp.first.`val` == x) {
                    nodeXPair = temp
                }
                if (temp.first.`val` == y) {
                    nodeYPair = temp
                }
                temp.first.left?.let {
                    queue.add(Pair(it, temp.first))
                }
                temp.first.right?.let {
                    queue.add(Pair(it, temp.first))
                }
            }
            if (nodeXPair != null && nodeYPair != null) {
                return nodeXPair.second != nodeYPair.second
            }
            if (nodeXPair != null || nodeYPair != null) return false
        }
        return false
    }

    println(levelOrderTraversal(tree, 4, 3))
}