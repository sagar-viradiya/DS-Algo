package datastructures

import java.util.*

/*
    Given a tree convert it to stack by traversing it in in-order.

    e.g Given a tree

             1
           /   \
          2     3
         / \   / \
        4   5 6   7

    Output = Stack |7 3 6 1 5 2 4|

 */

class Node<T>(val value: T, var leftNode: Node<T>? = null, var rightNode: Node<T>? = null)

fun main() {
    val tree = Node(1).apply {
        leftNode = Node(2).apply {
            leftNode = Node(4)
            rightNode = Node(5)
        }
        rightNode = Node(3).apply {
            leftNode = Node(6)
            rightNode = Node(7)
        }
    }

    val stack = Stack<Int>()
    convertTreeToStack(tree, stack)
    println(stack.toString())
}

private fun convertTreeToStack(tree: Node<Int>?, stack: Stack<Int>) {
    if (tree == null) return
    convertTreeToStack(tree.leftNode, stack)
    stack.push(tree.value)
    convertTreeToStack(tree.rightNode, stack)
}

