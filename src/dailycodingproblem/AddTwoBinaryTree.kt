package dailycodingproblem

/*
    Write a program to merge two binary trees. Each node in the new tree should hold a value equal to the sum of the
    values of the corresponding nodes of the input trees.

    If only one input tree has a node in a given position, the corresponding node in the new tree should match that input node.
 */
fun main() {
    val tree1 = TreeNode(1).apply {
        left = TreeNode(5).apply {
            left = TreeNode(8)
        }
        right = TreeNode(7)
    }

    val tree2 = TreeNode(2).apply {
        left = TreeNode(6).apply {
            right = TreeNode(7).apply {
                left = TreeNode(8)
            }
        }
    }
    val ans = tree1 + tree2
}

operator fun TreeNode?.plus(treeNode: TreeNode?): TreeNode? {

    val thisNode = this

    if (thisNode == null && treeNode == null) return null

    return TreeNode((thisNode?.`val` ?: 0 ) + (treeNode?.`val` ?: 0)).apply {
        left = thisNode?.left + treeNode?.left
        right = thisNode?.right + treeNode?.right
    }
}