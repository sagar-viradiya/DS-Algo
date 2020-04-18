package leetcode

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example:

    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
fun main() {
    val grid = arrayOf(intArrayOf(1, 2, 5), intArrayOf(3, 2, 1))

    if (grid.isEmpty() || grid[0].isEmpty()) {
        print(0)
        return
    }

    val pathSum = Array<IntArray>(grid.size) { IntArray(grid[0].size) }

    pathSum[0][0] = grid[0][0]

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (j - 1 > -1 && i - 1 > -1) {
                pathSum[i][j] = minOf(pathSum[i][j - 1], pathSum[i - 1][j]) + grid[i][j]
            } else if (j - 1 > -1) {
                pathSum[i][j] = pathSum[i][j - 1] + grid[i][j]
            } else if (i - 1 > -1) {
                pathSum[i][j] = pathSum[i - 1][j] + grid[i][j]
            } else {
                pathSum[i][j] = grid[i][j]
            }
        }
    }

    print(pathSum[grid.size - 1][grid[0].size - 1])
}