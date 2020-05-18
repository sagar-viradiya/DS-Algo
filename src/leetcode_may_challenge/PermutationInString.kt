package leetcode_may_challenge

/*
    Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

    Example 1:

    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:

    Input:s1= "ab" s2 = "eidboaoo"
    Output: False

    Note:
        The input strings only contain lower case letters.
        The length of both given strings is in range [1, 10,000].
 */
fun main() {
    val s1 = "ab"
    val s2 = "eidbaooo"

    if (s1.isEmpty() && s2.isEmpty()) {
        print(true)
        return
    }
    if (s1.isEmpty()) {
        print(false)
        return
    }
    if (s2.isEmpty()) {
        print(false)
        return
    }
    if (s1.length > s2.length) {
        print(false)
        return
    }

    val freqMapS1 = mutableMapOf<Char, Int>()
    val windowMap = mutableMapOf<Char, Int>()

    for (i in s1.indices) {
        if (freqMapS1.containsKey(s1[i])) {
            freqMapS1[s1[i]] = freqMapS1[s1[i]]!! + 1
        } else {
            freqMapS1[s1[i]] = 1
        }
        if (windowMap.containsKey(s2[i])) {
            windowMap[s2[i]] = windowMap[s2[i]]!! + 1
        } else {
            windowMap[s2[i]] = 1
        }
    }

    if (freqMapS1 == windowMap) {
        print(true)
        return
    }

    for (i in 1 until (s2.length - s1.length + 1)) {
        if (windowMap[s2[i - 1]]!! == 1) {
            windowMap.remove(s2[i - 1])
        } else {
            windowMap[s2[i - 1]] = windowMap[s2[i - 1]]!! - 1
        }
        if (windowMap.containsKey(s2[i + s1.length - 1])) {
            windowMap[s2[i + s1.length - 1]] = windowMap[s2[i + s1.length - 1]]!! + 1
        } else {
            windowMap[s2[i + s1.length - 1]] = 1
        }
        if (windowMap == freqMapS1) {
            print(true)
            return
        }
    }
    print(false)
}