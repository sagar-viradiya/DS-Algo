fun main(args: Array<String>) {

    val input1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"
    val input2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"

    val caching = Array(input1.length) { Array(input2.length) {Int.MAX_VALUE} }
    println(lcs(input1, input2, input1.length - 1, input2.length - 1, caching) + 1)
    print(lcsBottomUpApproach(input1, input2))

}

fun lcs(input1: String, input2: String, i: Int, j: Int, caching: Array<Array<Int>>): Int {

    if (i == 0 || j == 0) {
        caching[i][j] = 0
    } else if (caching[i][j] != Int.MAX_VALUE) {
        return caching[i][j]
    } else if (input1[i] == input2[j]) {
        caching[i][j] = 1 + lcs(input1, input2, i-1, j-1, caching)
    } else {
        caching[i][j] = maxOf(lcs(input1, input2, i-1, j, caching), lcs(input1, input2, i, j-1, caching))
    }

    return caching[i][j]
}

fun lcsBottomUpApproach(input1: String, input2: String): Int {

    val caching = Array(input1.length + 1) { IntArray(input2.length + 1) }

    for (i in 0..input1.length) {
        for (j in 0..input2.length) {
            if (i == 0 || j == 0) {
                caching[i][j] = 0
            } else if (input1[i-1] == input2[j-1]) {
                caching[i][j] = 1 + caching[i-1][j-1]
            } else {
                caching[i][j] = maxOf(caching[i][j-1], caching[i-1][j])
            }
        }
    }

    return caching[input1.length][input2.length]

}
