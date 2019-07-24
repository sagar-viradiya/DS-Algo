package datastructures

import java.lang.IllegalStateException
import java.util.*

class Graph<T> {

    data class Node<T>(val id: Int, val value: T, val adjacent: LinkedList<Node<T>> = LinkedList())

    private val nodes = mutableListOf<Node<T>>()
    private val nodeIds = mutableSetOf<Int>()

    fun add(node: Node<T>) {
        if (nodeIds.contains(node.id)) {
            throw IllegalStateException("Node is already in graph")
        }
        nodes += node
        nodeIds += node.id
    }

    fun remove(node: Node<T>) {
        if (!nodeIds.contains(node.id)) {
            throw IllegalStateException("Node is not present in graph")
        }
        nodes -= node
        nodeIds -= node.id

        for (node1 in nodes) {
            if (node1.adjacent.contains(node)) {
                node1.adjacent -= node
            }
        }
    }

    fun getNodes(): List<Node<T>> = nodes

    fun hasPath(source: Node<T>, destination: Node<T>): Boolean {
        val queue = ArrayDeque<Node<T>>()
        queue.add(source)
        val visitedNodeIds = mutableSetOf<Int>()
        var tempNode: Node<T>
        while (!queue.isEmpty()) {
            tempNode = queue.remove()
            if (visitedNodeIds.contains(tempNode.id)) {
                continue
            }
            if (tempNode == destination) {
                return true
            }

            visitedNodeIds.add(tempNode.id)
            queue.addAll(tempNode.adjacent)
        }

        return false
    }

    fun hasPathDFS(source: Node<T>, destination: Node<T>): Boolean {
        return DFS(source, destination)
    }

    fun DFS(source: Node<T>, destination: Node<T>, visited: MutableSet<Int> = mutableSetOf()): Boolean {

        if (visited.contains(source.id)) {
            return false
        }

        visited.add(source.id)

        if (source == destination) {
            return true
        }

        for (node in source.adjacent) {
            if (DFS(node, destination, visited)) {
                return true
            }
        }

        return false
    }

    fun DFSIterative(source: Node<T>, destination: Node<T>): Boolean {
        var start = source
        val visited: MutableSet<Int> = mutableSetOf()
        val stack = Stack<Node<T>>()

        stack.push(source)

        while (stack.isNotEmpty()) {
            if (visited.contains(start.id)) {
                continue
            }
            visited.add(start.id)
            if (start == destination) {
                return true
            }

            for (node in start.adjacent) {
                if (visited.contains(node.id)) {
                    continue
                }
                stack.push(node)
            }

            start = stack.pop()
        }

        return false

    }

    fun shortestPath(source: Node<T>, destination: Node<T>, visited: MutableSet<Int> = mutableSetOf()): Int {
        if (source == destination) {
            return 0
        }
        visited.add(source.id)
        val pathLength = source.adjacent
                .filter { !visited.contains(it.id) }
                .map { shortestPath(it, destination, visited) }
                .min() ?: Int.MAX_VALUE
        return if (pathLength == Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else {
            (1 + pathLength)
        }
    }

}
