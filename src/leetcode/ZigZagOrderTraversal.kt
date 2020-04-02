package leetcode

import java.util.*

/*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
    then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7

    return its zigzag level order traversal as:

    [
      [3],
      [20,9],
      [15,7]
    ]

 */
fun main() {
    val root = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val zigZagList = mutableListOf<LinkedList<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    var direction = 0

    var treeNode: TreeNode

    var tempList: MutableList<Int>

    while (queue.isNotEmpty()) {
        tempList = LinkedList()
        for (i in 0 until queue.size) {
            treeNode = queue.remove()
            if (direction % 2 == 0) {
                tempList.addLast(treeNode.`val`)
            } else {
                tempList.addFirst(treeNode.`val`)
            }
            if (treeNode.left != null) queue.add(treeNode.left)
            if (treeNode.right != null) queue.add(treeNode.right)
        }
        direction++
        zigZagList.add(tempList)
    }

    zigZagList.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}

