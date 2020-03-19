package dailycodingproblem

/*
    This problem was asked by LinkedIn.

    You are given a binary tree in a peculiar string representation.
    Each node is written in the form (lr), where l corresponds to the left child and r corresponds to the right child.

    If either l or r is null, it will be represented as a zero. Otherwise, it will be represented by a new (lr) pair.

    Here are a few examples:

    A root node with no children: (00)
    A root node with two children: ((00)(00))
    An unbalanced tree with three consecutive left children: ((((00)0)0)0)
    Given this representation, determine the depth of the tree.
 */
fun main() {
    val input = "((00)((0(((00)(00))0))0))"
    //val input = "((00)(00))"
    print(getDepthOfTree(input))
}

//O(N Log(N))
private fun getDepthOfNode(input: String): Int {
    if (input == "(00)") return 1
    return if (input[1] != '0' && input[input.length - 2] != '0') {
        val splitIndex = input.indexOf(")(")
        1 + maxOf(getDepthOfNode(input.substring(1, splitIndex + 1)), getDepthOfNode(input.substring(splitIndex + 1, input.length - 1)))
    } else if (input[1] == '0') {
        1 + getDepthOfNode(input.substring(2, input.length - 1))
    } else {
        1 + getDepthOfNode(input.substring(1, input.length - 2))
    }
}

//O(N) solution
private fun getDepthOfTree(input: String): Int {
    var depth = 0
    var maxDepth = 0

    for (char in input) {
       if (char == '(') {
            depth += 1
        } else if (char == ')') {
            depth -= 1
        }
        maxDepth = maxOf(maxDepth, depth)
    }
    return maxDepth
}