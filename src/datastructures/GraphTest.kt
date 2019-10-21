package datastructures

fun main() {
    val graph = Graph<Char>()
    
    val nodeA = Graph.Node(1, 'A')
    val nodeB = Graph.Node(2, 'B')
    val nodeC = Graph.Node(3, 'C')
    val nodeD = Graph.Node(4, 'D')
    val nodeE = Graph.Node(5, 'E')

    nodeA.adjacent.add(Graph.WeightedNode(nodeB, 4))
    nodeA.adjacent.add(Graph.WeightedNode(nodeC, 1))

    nodeB.adjacent.add(Graph.WeightedNode(nodeE, 4))

    nodeC.adjacent.add(Graph.WeightedNode(nodeB, 2))
    nodeC.adjacent.add(Graph.WeightedNode(nodeD, 4))

    nodeD.adjacent.add(Graph.WeightedNode(nodeE, 4))

    graph.add(nodeA)
    graph.add(nodeB)
    graph.add(nodeC)
    graph.add(nodeD)
    graph.add(nodeE)


    val distance = graph.dijkstrasAlgo(nodeA)

    distance.forEach {
        println(it.key.value + " -> " + it.value)
    }


}