package dailycodingproblem

/*
    Given a binary search tree, find the floor and ceiling of a given integer.
    The floor is the highest element in the tree less than or equal to an integer,
    while the ceiling is the lowest element in the tree greater than or equal to an integer.
 */
fun main() {
    val root = Node(6,
            Node(3,
                    Node(2,
                            Node(1)
                    ),
                    Node(4)
            ),
            Node(9,
                    Node(7),
                    Node(10,
                            rightNode = Node(11)
                    )
            )
    )
    val key = 8
    println(getFloor(root, key)?.`val`)
    println(getCeil(root, key)?.`val`)
}

private fun getFloor(root: Node?, key: Int): Node? {
    return when {
        root == null -> null
        root.`val` == key -> root
        root.`val` > key -> getFloor(root.leftNode, key)
        else -> {
            getFloor(root.rightNode, key) ?: root
        }
    }
}

private fun getCeil(root: Node?, key: Int): Node? {
    return when {
        root == null -> null
        root.`val` == key -> root
        root.`val` < key -> getCeil(root.rightNode, key)
        else -> getCeil(root.leftNode, key) ?: root
    }
}
