package tree


/*
Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35


For example, the inorder successor of 23 is 30

   10
  /  \
 5    30
     /  \
   22    35
    \
     23

Solution:

1 If right subtree of node is not NULL, then succ lies in right subtree. Do following.
  Go to right subtree and return the node with minimum key value in right subtree.
2 If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
  Travel up using the parent pointer until you see a node which is left child of it’s parent.
  The parent of such a node is the succ.

 */

data class Node(val `val`: Int, val parent: Node? = null, var left: Node? = null, var right: Node? = null)

fun main(args: Array<String>) {

    var input: Node = Node(0)

    val tree = Node(10).apply {
        left = Node(5, this)
        right = Node(30, this).apply {
            left = Node(22, this).apply {
                right = Node(23, this)
                input = right as Node
            }
            right = Node(35, this)
        }
    }


    if(input.right != null) {
        var root = input.right
        var temp = root!!.left
        while (temp != null) {
            root = temp
            temp = temp.left
        }
        print(root!!.`val`)
    } else {
        var current = input
        while (current.parent != null && current != (current.parent as Node).left) {
            current = current.parent as Node
        }
        print(current.parent!!.`val`)
    }

}