package dailycodingproblem

import kotlin.math.abs

/*
    You are the technical director of WSPT radio, serving listeners nationwide.
    For simplicity's sake we can consider each listener to live along a horizontal line stretching from 0 (west) to 1000 (east).

    Given a list of N listeners, and a list of M radio towers, each placed at various locations along this line,
    determine what the minimum broadcast range would have to be in order for each listener's home to be covered.

    For example, suppose listeners = [1, 5, 11, 20], and towers = [4, 8, 15]. In this case the minimum range would be 5,
    since that would be required for the tower at position 15 to reach the listener at position 20.
 */
fun main() {
    val listeners = intArrayOf(1, 5, 11, 20)
    val towers = intArrayOf(4, 8, 15)

    var minRang = 0

    var towerIndex = 0
    for (listener in listeners) {
        if (listener > towers[towerIndex]) {
            while (listener > towers[towerIndex] && towerIndex < towers.size - 1) {
                towerIndex++
            }
        }
        minRang = if (towerIndex == 0) {
            maxOf(minRang, abs(listener - towers[towerIndex]))
        } else {
            maxOf(minRang, minOf(abs(listener - towers[towerIndex - 1]), abs(listener - towers[towerIndex])))
        }
        if (towerIndex < towers.size - 1) towerIndex++
    }

    print(minRang)
}