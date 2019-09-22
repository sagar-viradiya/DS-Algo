package dailycodingproblem

/*
    Spreadsheets often use this alphabetical encoding for its columns: "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....

    Given a column number, return its alphabetical column id. For example, given 1, return "A". Given 27, return "AA".
 */

fun main() {
    val input = 705
    var num = input
    val charArray = CharArray(50)
    var charIndex = 49
    var rem = 0

    while (num > 0) {
        rem = num%26
        if (rem == 0) {
            charArray[charIndex--] = 'Z'
            num = (num/26) - 1
        } else {
            charArray[charIndex--] = 'A' + (rem - 1)
            num /= 26
        }
    }

    for (i in charIndex + 1 until 50) {
        print(charArray[i])
    }
}