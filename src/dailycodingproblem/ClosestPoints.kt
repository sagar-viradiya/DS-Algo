package dailycodingproblem

import kotlin.math.pow
import kotlin.math.sqrt

/*
    This problem was asked by Google.
    Given a set of points (x, y) on a 2D cartesian plane, find the two closest points.
    For example, given the points [(1, 1), (-1, -1), (3, 4), (6, 1), (-1, -6), (-4, -3)], return [(-1, -1), (1, 1)].
 */
fun main() {
    val points = arrayOf(Pair(1, 1), Pair(-1, -1), Pair(3, 4), Pair(6, 1), Pair(-1, -6), Pair(-4, -3))
    var minDistance = Double.MAX_VALUE
    var ans: Pair<Pair<Int, Int>, Pair<Int, Int>> = Pair(Pair(Int.MAX_VALUE, Int.MAX_VALUE), Pair(Int.MAX_VALUE, Int.MAX_VALUE))
    var tempDistance: Double
    for (i in 0..points.size - 2) {
        for (j in i + 1 until points.size) {
            tempDistance = distance(points[i], points[j])
            if (tempDistance < minDistance) {
                minDistance = tempDistance
                ans = Pair(points[i], points[j])
            }
        }
    }
    print(ans.toString())
}

private fun distance(pointA: Pair<Int, Int>, pointB: Pair<Int, Int>): Double {
    return sqrt((pointB.first - pointA.first).toDouble().pow(2) + (pointB.second - pointA.second).toDouble().pow(2))
}