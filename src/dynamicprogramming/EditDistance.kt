package dynamicprogramming

/*
    In order to transform one source string of text x[1..m]: m to a target string y[1..n]: n,
    we can perform various transformation operations. Our goal is, given x and y,
    to produce a series of transformations that change x to y.

    We may choose from among six transformation operations:

    Copy a charactervand then incrementing both i
    and j.

    Replace a character from x by another character c, and then
    incrementing both i and j.

    Delete a character from x by incrementing i but leaving j alone.

    Insert the character c and then incrementing j, but
    leaving i alone.

    Twiddle (i.e., exchange) the next two characters by copying them from x but
    in the opposite order.

    Kill the remainder of x. This operation, if performed, must
    be the final operation.
*/

fun main(args: Array<String>) {
    val str1 = "gesek"
    val str2 = "gsesk"
    val caching = Array(str1.length) { IntArray(str2.length) { -1 } }
    print(editDistance(0, 0, str1, str2, caching))
}

private fun editDistance(i: Int, j: Int, str1: String, str2: String, caching: Array<IntArray>): Int {

    if (i == str1.length) {
        return str2.length - j + 1
    }

    if (j == str2.length) {
        return 1
    }

    if (caching[i][j] != -1) {
        return caching[i][j]
    }

    if (str1[i] == str2[j]) {
        caching[i][j] = 1 + editDistance(i + 1, j + 1, str1, str2, caching)
        return caching[i][j]
    }

    if (i + 1 < str1.length && j + 1 < str2.length) {
        if (str1[i] == str2[j + 1] && str1[i + 1] == str2[j]) {
            caching[i][j] = 1 + editDistance(i + 2, j + 2, str1, str2, caching)
            return caching[i][j]
        }
    }

    caching[i][j] =  1 + minOf(editDistance(i + 1, j + 1, str1, str2, caching),
            editDistance(i + 1, j, str1, str2, caching),
            editDistance(i, j + 1, str1, str2, caching))

    return caching[i][j]

}