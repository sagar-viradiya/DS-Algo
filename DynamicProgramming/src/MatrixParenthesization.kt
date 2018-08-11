lateinit var scalarMultiplicationMatrix: Array<IntArray>
lateinit var partitionMatrix: Array<IntArray>

fun main(args: Array<String>) {

    //Change input for different use cases
    val input = listOf(Pair(30, 35), Pair(35, 15), Pair(15, 5), Pair(5, 10), Pair(10, 20), Pair(20, 25))

    scalarMultiplicationMatrix = Array(input.size) { IntArray(input.size) }
    partitionMatrix = Array(input.size) { IntArray(input.size) }

    optimalMultiplication(input, 0, input.size - 1)
    printOptimalParenthesization(0, input.size - 1)

}

fun optimalMultiplication(matrixDimension: List<Pair<Int, Int>>, i: Int, j: Int): Int {

    if (i != j || scalarMultiplicationMatrix[i][j] == 0) {

        (0 until j-i)
                .map {
                    k ->
                    val cost = optimalMultiplication(matrixDimension, i, i + k) +
                            optimalMultiplication(matrixDimension, i + k + 1, j) +
                            (matrixDimension[i].first * matrixDimension[i + k].second * matrixDimension[j].second)
                    Pair(i + k, cost)
                }.minBy {
                    it.second
                }.run {
                    if (this != null) {
                        partitionMatrix[i][j] = first
                        scalarMultiplicationMatrix[i][j] = second
                    }
                }
    }

    return scalarMultiplicationMatrix[i][j]

}

fun printOptimalParenthesization(i: Int, j: Int) {
    if (i == j) {
        print("A${i+1}")
    } else {
        print("(")
        printOptimalParenthesization(i, partitionMatrix[i][j])
        printOptimalParenthesization(partitionMatrix[i][j] +  1, j)
        print(")")
    }
}





