package dailycodingproblem

/*
Given a matrix of 1s and 0s, return the number of "islands" in the matrix.
A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.

For example, this matrix has 4 islands.

1 0 0 0 0
0 0 1 1 0
0 1 1 0 0
0 0 0 0 0
1 1 0 0 1
1 1 0 0 1
 */

fun main(args: Array<String>) {
    val input = arrayOf(
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(1, 0, 0, 1, 1)
    )

    var noOfIsland = 0

    for (i in 0 until input.size) {
        for (j in 0 until input[i].size) {
            if (input[i][j] == 1) {
                noOfIsland++
                floodFill(i, j, input)
            }
        }
    }

    print(noOfIsland)

}

private fun floodFill(startX: Int, startY: Int, input: Array<IntArray>) {
    input[startX][startY] = 0

    //Move to top
    if (startX - 1 > -1 && input[startX - 1][startY] != 0) {
        floodFill(startX - 1, startY, input)
    }

    //Move to bottom
    if (startX + 1 < input.size && input[startX + 1][startY] != 0) {
        floodFill(startX + 1, startY, input)
    }

    //Move to Left
    if (startY - 1 > -1 && input[startX][startY - 1] != 0) {
        floodFill(startX, startY - 1, input)
    }

    //Move to Right
    if (startY + 1 < input[startX].size && input[startX][startY + 1] != 0) {
        floodFill(startX, startY + 1, input)
    }
}