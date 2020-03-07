package dailycodingproblem

/*
    his problem was asked by Google.

    Given a binary search tree and a range [a, b] (inclusive), return the sum of the elements of the binary search tree
    within the range.

    For example, given the following tree:

        5
       / \
      3   8
     / \ / \
    2  4 6  10
    and the range [4, 9], return 23 (5 + 4 + 6 + 8).
 */

private class BSTNode(val `val`: Int, var leftNode: BSTNode? = null, var rightNode: BSTNode? = null)

fun main() {
    val bsTree = BSTNode(5).apply {
        leftNode = BSTNode(3).apply {
            leftNode = BSTNode(2)
            rightNode = BSTNode(4)
        }
        rightNode = BSTNode(8).apply {
            leftNode = BSTNode(6)
            rightNode = BSTNode(10)
        }
    }
    val rang = 4..9
    print(rangSum(bsTree, rang))
}

private fun rangSum(rootNode: BSTNode?, rang: IntRange): Int {
    if (rootNode == null) return 0
    return when {
        rootNode.`val` in rang -> {
            rootNode.`val` + rangSum(rootNode.leftNode, rang) + rangSum(rootNode.rightNode, rang)
        }
        rootNode.`val` < rang.first -> {
            rangSum(rootNode.rightNode, rang)
        }
        else -> {
            rangSum(rootNode.leftNode, rang)
        }
    }
}