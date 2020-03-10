package tree

/*
    You are given a tree (a simple connected graph with no cycles) having even number of nodes.

    Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of
    the forest contains an even number of nodes.

    Input:
    List of edges from
    List of edges to

    Output:
    Maximum number of edges you can remove to create even forest.

    As an example, the following tree with nodes can be cut at most 2 times to create an even forest.

       1
      / \
     2   3
        / \
       4   5
     / | \
    6  7  8

    The first cut would be in between 1 & 3 and second cut would be in between 3 & 4.
 */

var maximumEdge = 0

fun main() {
    //Input
    val edgeTo = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10)
    val edgeFrom = intArrayOf(1, 1, 3, 2, 1, 2, 6, 8, 8)
    countNodesToEvenForests(getGraph(edgeTo, edgeFrom), mutableSetOf())
    print(maximumEdge - 1)

}

//Convert input into graph
private fun getGraph(edgeTo: IntArray, edgeFrom: IntArray): Map<Int, List<Int>> {

    val graph = mutableMapOf<Int, MutableList<Int>>()

    for (i in edgeTo.indices) {
        if (graph[edgeTo[i]] == null) {
            graph[edgeTo[i]] = mutableListOf(edgeFrom[i])
        } else {
            graph[edgeTo[i]]!!.add(edgeFrom[i])
        }

        if (graph[edgeFrom[i]] == null) {
            graph[edgeFrom[i]] = mutableListOf(edgeTo[i])
        } else {
            graph[edgeFrom[i]]!!.add(edgeTo[i])
        }
    }
    return graph
}


//DFS approach.
private fun countNodesToEvenForests(graph: Map<Int, List<Int>>, visitedNode: MutableSet<Int>, root: Int = 1): Int {
    if (visitedNode.contains(root)) return 0
    visitedNode.add(root)
    val sumOfNodes = 1 + graph[root]!!.sumBy { countNodesToEvenForests(graph, visitedNode, it) }
    if (sumOfNodes % 2 == 0) maximumEdge++
    return sumOfNodes
}