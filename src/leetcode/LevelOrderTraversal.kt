package leetcode

import java.util.*

/*
    Given a binary tree, print the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
 */

private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4).apply {
                left = TreeNode(10).apply {
                    left = TreeNode(11).apply {
                        right = TreeNode(12)
                    }
                }
            }
        }
        right = TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(7).apply {
                    left = TreeNode(9)
                    right = TreeNode(8)
                }
            }
            right = TreeNode(6)
        }
    }

    val queue = ArrayDeque<TreeNode>()
    val levelOrder = mutableListOf<MutableList<Int>>()
    queue.push(root)
    var tempNode: TreeNode
    while (queue.isNotEmpty()) {
        val levelList = mutableListOf<Int>()
        for (i in 0 until queue.size) {
            tempNode = queue.remove()
            levelList.add(tempNode.`val`)
            if (tempNode.left != null) queue.add(tempNode.left!!)
            if (tempNode.right != null) queue.add(tempNode.right!!)
        }
        levelOrder.add(levelList)
    }

    levelOrder.forEach {
        it.forEach { print("$it ") }
        println()
    }
}