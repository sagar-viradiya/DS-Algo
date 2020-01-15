package leetcode

/*
    Given a binary tree, flatten it to a linked list in-place.

    For example, given the following tree:

        1
       / \
      2   5
     / \   \
    3   4   6
    The flattened tree should look like:

    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
 */
fun main() {
    var tree: TreeNode? = TreeNode(1).apply {
        left = TreeNode(3)
        right = TreeNode(4).apply {
            left = TreeNode(2).apply {
                right = TreeNode(5)
            }
        }
    }
    flattenTree(tree)

    while (tree != null) {
        print("${tree.`val`} -> ")
        tree = tree.right
    }

}

private fun flattenTree(node: TreeNode?) {

    if (node == null) return

    if (node.left == null && node.right == null) {
        return
    }

    if (node.left != null && node.right != null) {
        val tempRight = node.right
        flattenTree(node.left!!)
        node.right = node.left
        node.left = null
        var temp = node.right
        while (temp!!.right != null) {
            temp = temp.right
        }
        flattenTree(tempRight!!)
        temp.right = tempRight
    }

    else if (node.left != null) {
        flattenTree(node.left!!)
        node.right = node.left
        node.left = null
    }

    else if (node.right != null) {
        flattenTree(node.right!!)
    }
}