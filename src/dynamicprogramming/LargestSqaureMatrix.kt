package dynamicprogramming

/**
 * Given Matrix of 1s and 0s
 *
 * [0, 1, 1, 0, 1]
 * [1, 1, 0, 1, 0]
 * [0, 1, 1, 1, 0]
 * [1, 1, 1, 1, 0]
 * [1, 1, 1, 1, 1]
 * [0, 0, 0, 0, 0]
 *
 * Find the size of largest square matrix within it having 1
 * In this case largest square matrix size having 1 is 3.
 */

data class MaxTuple(val coordinates: Pair<Int, Int>, val size: Int)

fun main(args: Array<String>) {

    val matrix = arrayOf(
            intArrayOf(0, 1, 1, 0, 1),
            intArrayOf(1, 1, 0, 1, 0),
            intArrayOf(0, 1, 1, 1, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(0, 0, 0, 0, 0))
    val maxTuple = getLargestSquareMatrixCoordinates(matrix)
    print(maxTuple)

}

fun getLargestSquareMatrixCoordinates(matrix: Array<IntArray>): MaxTuple {

    var max = Int.MIN_VALUE
    var coordinates = Pair(0, 0)
    val tempMatrix = Array(matrix.size) { IntArray(matrix[0].size) }
    for (i in 0 until matrix[0].size) {
        tempMatrix[0][i] = matrix[0][i]
    }
    for (j in 0 until matrix.size) {
        tempMatrix[j][0] = matrix[j][0]
    }
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] == 1) {
                tempMatrix[i][j] = minOf(tempMatrix[i][j - 1], tempMatrix[i - 1][j], tempMatrix[i - 1][j - 1]) + 1
                if (max < tempMatrix[i][j]) {
                    max = tempMatrix[i][j]
                    coordinates = Pair(j + 1, i + 1)
                }
            }
        }
    }
    return MaxTuple(Pair(coordinates.first - (max - 1), coordinates.second - (max - 1)), max)

}