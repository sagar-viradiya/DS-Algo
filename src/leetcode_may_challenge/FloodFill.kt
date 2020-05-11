package leetcode_may_challenge

/*
    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
    "flood fill" the image.

    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
    Replace the color of all of the aforementioned pixels with the newColor.

    At the end, return the modified image.

    Example 1:

    Input:
    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr = 1, sc = 1, newColor = 2
    Output: [[2,2,2],[2,2,0],[2,0,1]]
    Explanation:
    From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
    by a path of the same color as the starting pixel are colored with the new color.
    Note the bottom corner is not colored 2, because it is not 4-directionally connected
    to the starting pixel.
 */
val directions = arrayOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))

fun main() {
    val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
    )
    val sr = 1
    val sc = 1
    val newColor = 2

    if (newColor != image[sr][sc]) {
        floodFill(image, sr, sc, newColor, image[sr][sc])
    }

    //Print updated image
    for (ints in image) {
        for (int in ints) {
            print("$int ")
        }
        println()
    }
}

//DFS
private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int, oldColor: Int) {
    if (image[sr][sc] != oldColor) return
    image[sr][sc] = newColor
    for (direction in directions) {
        val newSr = sr + direction.first
        val newSc = sc + direction.second
        if (newSr < image.size && newSc < image[0].size && newSc >= 0 && newSr >= 0) {
            floodFill(image, newSr, newSc, newColor, oldColor)
        }
    }
}