package leetcode

/*
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:

    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

fun main() {
    val s = "abcabcbb"

    var max = 0
    var start = 0
    var char: Char
    val charMap = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        char = s[i]
        if (charMap[char] != null && charMap[char]!! >= start) {
            start = charMap[char]!! + 1
        }
        charMap[char] = i
        max = kotlin.math.max(max, i - start + 1)
    }
    print(max)
}