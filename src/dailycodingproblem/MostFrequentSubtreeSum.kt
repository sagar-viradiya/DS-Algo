package practice

/*
    Given the root of a tree, you are asked to find the most frequent subtree sum.
    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
    (including the node itself). So what is the most frequent subtree sum value? If there is a tie,
    return all the values with the highest frequency in any order.

    Examples 1
    Input:

      5
     /  \
    2   -3
    return [2, -3, 4], since all the values happen only once, return all of them in any order.

    Examples 2
    Input:

      5
     /  \
    2   -5
    return [2], since 2 happens twice, however -5 only occur once.
 */

class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}

var maxCount = 0

fun main() {
    val input = TreeNode(5).apply {
        left = TreeNode(2).apply {
            left = TreeNode(-5).apply {
                left = TreeNode(3)
                right = TreeNode(2)
            }
            right = TreeNode(7).apply {
                left = TreeNode(1)
                right = TreeNode(-7)
            }
        }
        right  = TreeNode(-3).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
    }
    val listOfSum = mutableListOf<Int>()
    getSubTreeSum(input, listOfSum, mutableMapOf())
    println(listOfSum.toIntArray())

}

fun getSubTreeSum(root: TreeNode, sumList: MutableList<Int>, countMap: MutableMap<Int, Int>): Int {
    val sum = if (root.left == null && root.right == null) {
        root.`val`
    } else if (root.left != null && root.right == null) {
        root.`val` + getSubTreeSum(root.left!!, sumList, countMap)
    } else if (root.left == null && root.right != null) {
        root.`val` + getSubTreeSum(root.right!!, sumList, countMap)
    } else {
        root.`val` + getSubTreeSum(root.left!!, sumList, countMap) + getSubTreeSum(root.right!!, sumList, countMap)
    }
    updateCountInfo(sum, sumList, countMap)
    return sum
}

fun updateCountInfo(sum: Int, sumList: MutableList<Int>, countMap: MutableMap<Int, Int>) {
    if (countMap[sum] != null) {
        countMap[sum] = countMap[sum]!! + 1
    } else {
        countMap[sum] = 1
    }
    if (maxCount < countMap[sum]!!) {
        maxCount = countMap[sum]!!
        sumList.clear()
    }
    if (maxCount == countMap[sum]) {
        sumList.add(sum)
    }
}