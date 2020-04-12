package leetcode


/*
     Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example:
    Given a binary tree

              1
             / \
            2   3
           / \
          4   5

    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.
 */
fun main() {
    val root: TreeNode? = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(5)
    }
    print(getDiameter(root).first)
}

private fun getDiameter(node: TreeNode?): Pair<Int, Int> {
    if (node == null) return Pair(0, 0)
    val leftSubTreePair = getDiameter(node.left)
    val rightSubTreePair = getDiameter(node.right)
    val diameter = maxOf(
            leftSubTreePair.first,
            rightSubTreePair.first,
            leftSubTreePair.second + rightSubTreePair.second
    )
    return Pair(diameter, 1 + maxOf(leftSubTreePair.second, rightSubTreePair.second))
}