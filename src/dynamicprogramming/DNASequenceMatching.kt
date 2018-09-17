package dynamicprogramming

/*
    There are several methods for measuring the similarity of two DNA sequences by aligning them.
    One such method to align two sequences x and y consists of inserting spaces at arbitrary locations in the two
    sequences (including at either end) so that the resulting sequences x` and y` have the same length but do not have a
    space in the same position (i.e., for no position j are both x`[j]  and y`[j]  a space). Then we assign a “score”
    to each position. Position j receives a score as follows:

      +1 if x0OEj  D y0OEj  and neither is a space,
     -1 if x0OEj  ¤ y0OEj  and neither is a space,
     -2 if either x0OEj  or y0OEj  is a space.

    The score for the alignment is the sum of the scores of the individual positions. Find the maximum score that you
    can achive so that you have optimal alignment.

    For example, given the sequences x = GATCGGCAT and y = CAATGTGAATC, one alignment is

    G ATCG GCAT
    CAAT GTGAATC
    -*++*+*+-++*

    this alignment has a total score of -4. However this is not optimal alignment. Optimal alignment is as follow

    G ATCGGCAT
    CAATGTGAATC
    -*++--+-++*

    this alignment has a total score of -3 which is optimal.

*/

fun main(args: Array<String>) {
    val dna1 = "GATCGGCAT"
    val dna2 = "CAATGTGAATC"
    val caching = Array (dna1.length) { IntArray (dna2.length) { -1 }}
    println(matchDna(0, 0, dna1, dna2, caching))
    print(matchDna(dna1, dna2))
}

private fun matchDna(i: Int, j: Int, dna1: String, dna2: String, caching: Array<IntArray>): Int {

    if (i == dna1.length) {
        return -2 * (dna2.length - j)
    }

    if (j == dna2.length) {
        return -2 * (dna1.length - i)
    }

    if (caching[i][j] != -1) {
        return caching[i][j]
    }

    if (dna1[i] == dna2[j]) {
        caching[i][j] = 1 + matchDna(i + 1, j + 1, dna1, dna2, caching)
        return caching[i][j]
    }

    caching[i][j] =  maxOf(-2 + matchDna(i + 1, j, dna1, dna2, caching),
            -2 + matchDna(i, j + 1, dna1, dna2, caching),
            -1 + matchDna(i + 1, j + 1, dna1, dna2, caching))
    return caching[i][j]

}

//Bottom up approach
private fun matchDna(dna1: String, dna2: String): Int {

    val caching = Array (dna1.length + 1) { IntArray(dna2.length + 1) }

    caching[dna1.length][dna2.length] = 0

    for (i in 0 until dna1.length) {
        caching[i][dna2.length] = -2
    }

    for (j in 0 until dna2.length) {
        caching[dna1.length][j] = -2
    }

    for (i in dna1.length - 1 downTo 0) {
        for (j in dna2.length - 1 downTo 0) {
            if (dna1[i] == dna2[j]) {
                caching[i][j] = 1 + caching[i + 1][j + 1]
            } else {
                caching[i][j] = maxOf(-2 + caching[i + 1][j],
                        -2 + caching[i][j + 1],
                        -1 + caching[i + 1][j + 1])
            }
        }
    }

    return caching[0][0]

}