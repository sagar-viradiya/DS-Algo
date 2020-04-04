package dailycodingproblem

import java.lang.StringBuilder

/*
    This problem was asked by Twitter.

    Given a string, sort it in decreasing order based on the frequency of characters.
    If there are multiple possible solutions, return any of them.

    For example, given the string tweet, return tteew. eettw would also be acceptable.
 */
fun main() {
    val string = "tweet"

    val charFrequency = mutableMapOf<Char, Int>()

    for (char in string) {
        if (charFrequency[char] == null) {
            charFrequency[char] = 1
            continue
        }
        charFrequency[char] = charFrequency[char]!! + 1
    }

    val sortedCharFrequency = charFrequency.toList().sortedByDescending { it.second }

    val result = StringBuilder()

    sortedCharFrequency.forEach {
        repeat(it.second) { _ ->
            result.append(it.first)
        }
    }

    print(result)

}