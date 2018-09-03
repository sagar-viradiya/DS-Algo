package dynamicprogramming

/*
    Find the length of longest palindrome that is a subsequence
    of a given input string. For example, given the input "character", your algorithm
    should return 5 since "carac" is longest palindrome subsequence.
*/

fun main(args: Array<String>) {

    val input = "character"
    val charArray = input.toCharArray()
    val caching = Array(input.length) { IntArray(input.length) { -1 } }
    println(getPalindromeSubSequence(0, charArray.size - 1, charArray, caching))

}

private fun getPalindromeSubSequence(i: Int, j: Int, charArray: CharArray, caching: Array<IntArray>): Int {

    return when {
        caching[i][j] != -1 -> caching[i][j]
        i == j -> 1
        i > j -> 0
        charArray[i] == charArray[j] -> {
            caching[i][j] = 2 + getPalindromeSubSequence(i+1, j-1, charArray, caching)
            caching[i][j]
        }
        else -> {
            caching[i][j] = maxOf(getPalindromeSubSequence(i, j-1, charArray, caching),
                    getPalindromeSubSequence(i+1, j, charArray, caching))
            caching[i][j]
        }
    }

}
