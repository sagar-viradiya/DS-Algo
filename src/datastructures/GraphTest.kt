package datastructures

fun main() {
    val graph = Graph<Char>()
    
    /*val nodeA = Graph.Node(1, 'A')
    val nodeB = Graph.Node(2, 'B')
    val nodeC = Graph.Node(3, 'C')
    val nodeD = Graph.Node(4, 'D')
    val nodeE = Graph.Node(5, 'E')

    nodeA.adjacent.add(Graph.WeightedNode(nodeB, 4))
    nodeA.adjacent.add(Graph.WeightedNode(nodeC, 1))

    nodeB.adjacent.add(Graph.WeightedNode(nodeE, 4))

    nodeC.adjacent.add(Graph.WeightedNode(nodeB, 2))
    nodeC.adjacent.add(Graph.WeightedNode(nodeD, 4))

    nodeD.adjacent.add(Graph.WeightedNode(nodeE, 4))*/

    /*val nodeS = Graph.Node(1, 'S')
    val nodeT = Graph.Node(2, 'T')
    val nodeY = Graph.Node(3, 'Y')
    val nodeX = Graph.Node(4, 'X')
    val nodeZ = Graph.Node(5, 'Z')


    nodeS.adjacent.add(Graph.WeightedNode(nodeT, 10))
    nodeS.adjacent.add(Graph.WeightedNode(nodeY, 5))

    nodeT.adjacent.add(Graph.WeightedNode(nodeX, 1))
    nodeT.adjacent.add(Graph.WeightedNode(nodeY, 2))

    nodeY.adjacent.add(Graph.WeightedNode(nodeT, 3))
    nodeY.adjacent.add(Graph.WeightedNode(nodeX, 9))
    nodeY.adjacent.add(Graph.WeightedNode(nodeZ, 2))

    nodeX.adjacent.add(Graph.WeightedNode(nodeZ, 4))

    nodeZ.adjacent.add(Graph.WeightedNode(nodeX, 6))
    nodeZ.adjacent.add(Graph.WeightedNode(nodeS, 7))

    graph.add(nodeS)
    graph.add(nodeT)
    graph.add(nodeY)
    graph.add(nodeX)
    graph.add(nodeZ)*/

    /*val node0 = Graph.Node(1, 0)
    val node1 = Graph.Node(2, 1)
    val node2 = Graph.Node(3, 2)
    val node3 = Graph.Node(4, 3)
    val node4 = Graph.Node(5, 4)

    node0.adjacent.add(Graph.WeightedNode(node1, 4))
    node0.adjacent.add(Graph.WeightedNode(node2, 1))

    node1.adjacent.add(Graph.WeightedNode(node3, 1))

    node2.adjacent.add(Graph.WeightedNode(node1, 2))
    node2.adjacent.add(Graph.WeightedNode(node3, 5))

    node3.adjacent.add(Graph.WeightedNode(node4, 3))


    graph.add(node0)
    graph.add(node1)
    graph.add(node2)
    graph.add(node3)
    graph.add(node4)*/

    /*val node0 = Graph.Node(0, 0)
    val node1 = Graph.Node(1, 1)
    val node2 = Graph.Node(2, 2)
    val node3 = Graph.Node(3, 3)
    val node4 = Graph.Node(4, 4)
    val node5 = Graph.Node(5, 5)
    val node6 = Graph.Node(6, 6)
    val node7 = Graph.Node(7, 7)
    val node8 = Graph.Node(8, 8)
    val node9 = Graph.Node(9, 9)

    node0.adjacent.add(Graph.WeightedNode(node1, 5))

    node1.adjacent.add(Graph.WeightedNode(node6, 60))
    node1.adjacent.add(Graph.WeightedNode(node2, 20))
    node1.adjacent.add(Graph.WeightedNode(node5, 30))

    node2.adjacent.add(Graph.WeightedNode(node3, 10))
    node2.adjacent.add(Graph.WeightedNode(node4, 75))

    node3.adjacent.add(Graph.WeightedNode(node2, -15))

    node4.adjacent.add(Graph.WeightedNode(node9, 100))

    node5.adjacent.add(Graph.WeightedNode(node6, 5))
    node5.adjacent.add(Graph.WeightedNode(node8, 50))
    node5.adjacent.add(Graph.WeightedNode(node4, 25))

    node6.adjacent.add(Graph.WeightedNode(node7, -50))

    node7.adjacent.add(Graph.WeightedNode(node8,  -10))


    graph.add(node0)
    graph.add(node1)
    graph.add(node2)
    graph.add(node3)
    graph.add(node4)
    graph.add(node5)
    graph.add(node6)
    graph.add(node7)
    graph.add(node8)
    graph.add(node9)

    val distance = graph.bellmenFordAlgo(node0)

    distance.forEach {
        println(it.key.value.toString() + " -> " + it.value)
    }*/

    val nodeC = Graph.Node(1, 'C')
    val nodeA = Graph.Node(2, 'A')
    val nodeB = Graph.Node(3, 'B')
    val nodeD = Graph.Node(4, 'D')
    val nodeE = Graph.Node(5, 'E')
    val nodeF = Graph.Node(6, 'F')
    val nodeG = Graph.Node(7, 'G')
    val nodeH = Graph.Node(8, 'H')

    nodeC.adjacent.add(Graph.WeightedNode(nodeD , 8))
    nodeC.adjacent.add(Graph.WeightedNode(nodeG, 11))
    nodeA.adjacent.add(Graph.WeightedNode(nodeB, 3))
    nodeA.adjacent.add(Graph.WeightedNode(nodeC, 6))
    nodeB.adjacent.add(Graph.WeightedNode(nodeD, 4))
    nodeB.adjacent.add(Graph.WeightedNode(nodeC, 4))
    nodeB.adjacent.add(Graph.WeightedNode(nodeE, 11))
    nodeD.adjacent.add(Graph.WeightedNode(nodeE, -4))
    nodeD.adjacent.add(Graph.WeightedNode(nodeF, 5))
    nodeD.adjacent.add(Graph.WeightedNode(nodeG, 2))
    nodeE.adjacent.add(Graph.WeightedNode(nodeH, 9))
    nodeF.adjacent.add(Graph.WeightedNode(nodeH, 1))
    nodeG.adjacent.add(Graph.WeightedNode(nodeH, 2))


    graph.add(nodeA)
    graph.add(nodeB)
    graph.add(nodeC)
    graph.add(nodeD)
    graph.add(nodeE)
    graph.add(nodeF)
    graph.add(nodeG)
    graph.add(nodeH)


    val distance = graph.singleSourceShortestPathDAG(nodeA)

    distance.forEach {
        println(it.key.value.toString() + " -> " + it.value)
    }


}