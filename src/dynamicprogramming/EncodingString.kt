package dynamicprogramming

/**
 * Given mapping of a -> 1, b -> 2, c -> 3, d -> 4........z -> 26
 * Find number of ways you can encode given string of digits
 *
 * e.g input -> 1212
 *
 * There are 5 ways to encode 1212
 * abab, lab, aub, abl, ll
 *
 * output -> 5
 *
 * e.g input -> 01
 * output -> 0
 *
 * Assume given input only has digits
 */

fun main(args: Array<String>) {
    val input1 = "1231671326"
    val input2 = "5012"
    val caching1 = IntArray(input1.length) { -1 }
    val caching2 = IntArray(input2.length) { -1 }
    println(numWays(input1, 0, caching1))
    println(numWays(input2, 0, caching2))
}

private fun numWays(input: String, startIndex: Int, caching: IntArray): Int {
    when {
        input[startIndex] == '0' -> return 0
        startIndex == input.length - 1 -> return 1
        caching[startIndex] != -1 -> return caching[startIndex]
        startIndex == input.length - 2 -> {
            caching[startIndex] = if (input.substring(startIndex).toInt() < 27) 2 else 1
            return caching[startIndex]
        }
        else -> {
            caching[startIndex] = numWays(input, startIndex + 1, caching)
            if (input.substring(startIndex..startIndex+1).toInt() < 27) {
                caching[startIndex] += numWays(input, startIndex + 2, caching)
            }
            return caching[startIndex]
        }
    }
}



