package dynamicprogramming

fun main(args: Array<String>) {
    val array = intArrayOf(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7)
    print(maximumSubArray(array))
}

//Bottom up approach
private fun maximumSubArray(array: IntArray): MaximumTuple {
    val solutions = IntArray(array.size + 1)

    var startIndex = -1
    var startIndexTemp = -1
    var currentMax = 0
    var endIndex = -1
    var temp: Int

    for (i in 1..array.size) {
        temp = solutions[i-1] + array[i-1]
        if (temp > array[i-1]) {
            solutions[i] = temp
        } else {
            solutions[i] = array[i-1]
            startIndexTemp = i-1
        }
        if (currentMax < solutions[i]) {
            startIndex = startIndexTemp
            endIndex = i-1
            currentMax = solutions[i]
        }
    }

    return MaximumTuple(startIndex, endIndex, currentMax)
}

data class MaximumTuple(val low: Int, val high: Int, val sum: Int)