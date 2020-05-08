package leetcode_may_challenge

/*
    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
    Check if these points make a straight line in the XY plane.

    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false
 */

fun main() {
    val coordinates = arrayOf<Pair<Int, Int>>(
            Pair(1, 2),
            Pair(2, 3),
            Pair(3, 4),
            Pair(4, 5),
            Pair(5, 6),
            Pair(6, 7)
    )

    val point1 = coordinates[0]
    val point2 = coordinates[1]

    val b: Int
    var m = Int.MAX_VALUE

    if (point2.first - point1.first == 0) {
        b = point1.first
    } else {
        m = (point2.second - point1.second) / (point2.first - point1.first)
        b = point1.second - (m * point1.first)
    }

    var point: Pair<Int, Int>
    for (i in 2 until coordinates.size) {
        point = coordinates[i]
        if (m == Int.MAX_VALUE && point.first != b) {
            print(false)
            return
        } else if (point.second - (m * point.first) != b) {
            print(false)
            return
        }
    }
    print(true)
}