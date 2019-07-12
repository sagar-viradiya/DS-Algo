package dailycodingproblem

/*

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

 */

class Node(val `val`: Int, val leftNode: Node? = null, val rightNode: Node? = null)

fun main(args: Array<String>) {
    val tree = Node(0, Node(1), Node(0, Node(1, Node(1), Node(1)), Node(1)))
    print(getNumOfUniversalValTree(tree))
}

private fun getNumOfUniversalValTree(root: Node?): Int {
    if (root == null) {
        return 0
    }

    var num = getNumOfUniversalValTree(root.leftNode) + getNumOfUniversalValTree(root.rightNode)

    if ((root.leftNode == null && root.rightNode == null) ||
        (root.`val` == root.leftNode!!.`val` && root.`val` == root.rightNode!!.`val`)) {
        num++
    }

    return num
}