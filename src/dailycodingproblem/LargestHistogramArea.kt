package dailycodingproblem

/*
    This problem was asked by Square.

    You are given a histogram consisting of rectangles of different heights.
    These heights are represented in an input list, such that [1, 3, 2, 5] corresponds to the following diagram:

          x
          x
      x   x
      x x x
    x x x x
    Determine the area of the largest rectangle that can be formed only from the bars of the histogram.
    For the diagram above, for example, this would be six, representing the 2 x 3 area at the bottom right.
 */

fun main() {
    val heights = intArrayOf(1, 3, 2, 5)

    var maximumArea = 0
    var leftBar: Int
    var rightBar: Int
    for (i in heights.indices) {
        leftBar = i
        rightBar = i
        while (leftBar > 0 && heights [leftBar - 1] >= heights[i]) {
            leftBar--
        }
        while (rightBar < heights.size - 1 && heights[rightBar + 1] >= heights[i]) {
            rightBar++
        }
        maximumArea = maxOf(maximumArea, heights[i] * (rightBar - leftBar + 1))
    }

    print(maximumArea)
}