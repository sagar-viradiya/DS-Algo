package datastructures

import java.util.*

class Graph<T> {

    data class Node<T>(val id: Int, val value: T, val adjacent: LinkedList<WeightedNode<T>> = LinkedList())

    class WeightedNode<T>(val node: Node<T>, val weight: Int = 1): Comparable<WeightedNode<T>> {
        override fun compareTo(other: WeightedNode<T>): Int {
            return when {
                weight > other.weight -> 1
                weight < other.weight -> -1
                else -> 0
            }
        }
    }

    private val nodes = mutableSetOf<Node<T>>()
    private val nodeIds = mutableSetOf<Int>()

    private val weightedNodes = mutableSetOf<WeightedNode<T>>()


    fun add(node: Node<T>) {
        check(!nodeIds.contains(node.id)) { "Node is already in graph" }
        nodes += node
        nodeIds += node.id
    }

    fun remove(node: Node<T>) {
        check(nodeIds.contains(node.id)) { "Node is not present in graph" }
        nodes -= node
        nodeIds -= node.id

        for (node1 in nodes) {
            val weightedNode = node1.adjacent.first { it.node == node }
            node1.adjacent -= weightedNode
        }
    }

    fun getNodes(): List<Node<T>> = nodes.toList()

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
            queue.addAll(tempNode.adjacent.map { it.node })
        }

        return false
    }

    fun hasPathDFS(source: Node<T>, destination: Node<T>): Boolean {
        return DFS(source, destination)
    }

    //Recommended for unweighted graph
    fun shortestPathBFS(source: Node<T>, destination: Node<T>): Int {

        if (source == destination) return 0

        val distanceMap = mutableMapOf<Node<T>, Int>()
        val queue = ArrayDeque<Node<T>>()
        queue.add(source)
        distanceMap[source] = 0
        var tempNode: Node<T>

        while (!queue.isEmpty()) {
            tempNode = queue.remove()
            tempNode.adjacent.filter { distanceMap[it.node] == null }.forEach {
                if (destination == it) return distanceMap[tempNode]!! + 1
                distanceMap[it.node] = distanceMap[tempNode]!! + 1
                queue.add(it.node)
            }
        }

        //Return -1 if destination not found
        return -1
    }

    //O(E*log(E * V))
    //Recommended for +ve weighted graphs
    fun dijkstrasAlgo(source: Node<T>): Map<Node<T>, Int> {
        val distanceTable = mutableMapOf<Node<T>, Int>()
        distanceTable[source] = 0
        val priorityQueue = PriorityQueue<WeightedNode<T>>()
        val visitedNodeIds = mutableSetOf<Int>()
        priorityQueue.add(WeightedNode(source, 0))
        visitedNodeIds.add(source.id)

        var temp: Node<T>

        while (priorityQueue.isNotEmpty()) {
            temp = priorityQueue.remove().node
            temp.adjacent.forEach {
                if (distanceTable[it.node] == null) {
                    distanceTable[it.node] = distanceTable[temp]!! + it.weight
                } else {
                    distanceTable[it.node] = minOf(distanceTable[it.node]!!, distanceTable[temp]!! + it.weight)
                }
                if (!visitedNodeIds.contains(it.node.id)) {
                    priorityQueue.add(it)
                    visitedNodeIds.add(it.node.id)
                }
            }
        }
        return distanceTable
    }

    //O(VE)
    //Recommended For -ve weight graphs
    fun bellmenFordAlgo(source: Node<T>): Map<Node<T>, Int> {
        val distanceTable = mutableMapOf<Node<T>, Int>()
        distanceTable[source] = 0
        val queue = ArrayDeque<Node<T>>()
        val visitedNodes = mutableSetOf<Int>()

        var temp: Node<T>
        for (i in 1 until nodes.size) {
            queue.clear()
            visitedNodes.clear()
            queue.add(source)
            visitedNodes.add(source.id)
            while (queue.isNotEmpty()) {
                temp = queue.remove()
                temp.adjacent.forEach {

                    //Relaxation of edges
                    val distance = distanceTable[temp]!! + it.weight
                    if (distanceTable[it.node] == null || distance < distanceTable[it.node]!!) {
                        distanceTable[it.node] = distance
                    }

                    if (!visitedNodes.contains(it.node.id)) {
                        visitedNodes.add(it.node.id)
                        queue.add(it.node)
                    }
                }
            }
        }

        queue.clear()
        visitedNodes.clear()
        queue.add(source)
        visitedNodes.add(source.id)
        while (queue.isNotEmpty()) {
            temp = queue.remove()
            temp.adjacent.forEach {
                val distance = distanceTable[temp]!! + it.weight
                check(distance < distanceTable[it.node]!!) { "Graph has -ve cycles." }
                if (!visitedNodes.contains(it.node.id)) {
                    visitedNodes.add(it.node.id)
                    queue.add(it.node)
                }
            }
        }

        return distanceTable
    }

    //Recommended for DAG (Handles -ve weights also)
    fun singleSourceShortestPathDAG(source: Node<T>): Map<Node<T>, Int> {
        val topologicalSorting = topologicalSorting()
        val distanceTable = mutableMapOf<Node<T>, Int>()
        distanceTable[source] = 0
        var tempDistance = 0
        topologicalSorting.forEach {
            it.adjacent.forEach { adjacentNode ->
                tempDistance = distanceTable[it]!! + adjacentNode.weight
                if (distanceTable[adjacentNode.node] == null || distanceTable[adjacentNode.node]!! > tempDistance) {
                    distanceTable[adjacentNode.node] = tempDistance
                }
            }
        }

        return distanceTable
    }

    fun topologicalSorting(): List<Node<T>> {
        val visitedNode = mutableSetOf<Int>()
        val sortingList = LinkedList<Node<T>>()
        nodes.forEach {
            if (!visitedNode.contains(it.id)) {
                topologicalDFS(it, sortingList, visitedNode)
            }
        }
        return sortingList
    }

    fun topologicalDFS(start: Node<T>, nodeList: LinkedList<Node<T>>, visitedNode: MutableSet<Int>) {

        if (visitedNode.contains(start.id)) return
        visitedNode.add(start.id)
        if (start.adjacent.isEmpty()) {
            nodeList.addFirst(start)
            return
        }

        start.adjacent.forEach {
            topologicalDFS(it.node, nodeList, visitedNode)
        }

        nodeList.addFirst(start)
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
            if (DFS(node.node, destination, visited)) {
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
                if (visited.contains(node.node.id)) {
                    continue
                }
                stack.push(node.node)
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
                .filter { !visited.contains(it.node.id) }
                .map { shortestPath(it.node, destination, visited) }
                .min() ?: Int.MAX_VALUE
        return if (pathLength == Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else {
            (1 + pathLength)
        }
    }

}
