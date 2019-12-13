package dailycodingproblem

/*
    There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
    The bricks have the same height but different width.
    You want to draw a vertical line from the top to the bottom and cross the least bricks.

    The brick wall is represented by a list of rows.
    Each row is a list of integers representing the width of each brick in this row from left to right.

    If your line go through the edge of a brick, then the brick is not considered as crossed.
    You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

    You cannot draw a line just along one of the two vertical edges of the wall,
    in which case the line will obviously cross no bricks.


    Example:

    Input: [[1,2,2,1],
            [3,1,2],
            [1,3,2],
            [2,4],
            [3,1,2],
            [1,3,1,1]]

    Output: 2

 */
fun main() {
    val wall = listOf(listOf(1,2,2,1),
            listOf(3,1,2),
            listOf(1,3,2),
            listOf(2,4),
            listOf(3,1,2),
            listOf(1,3,1,1))

    val edgeMap = mutableMapOf<Int, Int>()
    var maxCount = 0
    var distance: Int
    for (i in wall.indices) {
        distance = 0
        for (j in 0 until wall[i].size - 1) {
            distance += wall[i][j]
            if (edgeMap[distance] == null) {
                edgeMap[distance] = 1
            } else {
                edgeMap[distance] = edgeMap[distance]!! + 1
            }
            maxCount = maxOf(edgeMap[distance]!!, maxCount)
        }
    }
    print(wall.size - maxCount)
}