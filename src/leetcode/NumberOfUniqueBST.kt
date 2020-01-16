package leetcode

/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
    Input: 3
    Output: 5
    Explanation:
    Given n = 3, there are a total of 5 unique BST's:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */
fun main() {
    val n = 7

    val cache = IntArray(n + 1)
    cache[0] = 1
    cache[1] = 1
    cache[2] = 2
    cache[3] = 5

    //Bottom-up approach with O(n^2)
    for (i in 4..n) {
        for (j in i downTo 1) {
            cache[i] += cache[i - j] * cache[j - 1]
        }
    }
    print(cache[n])
}