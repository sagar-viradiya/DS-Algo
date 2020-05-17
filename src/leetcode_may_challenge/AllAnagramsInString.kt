package leetcode_may_challenge

/*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

    The order of output does not matter.

    Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
    [0, 1, 2]

    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
fun main() {
    val s = "cbaebabacd"
    val p = "abc"

    val freqMapP = mutableMapOf<Char, Int>()
    val windowMap = mutableMapOf<Char, Int>()

    val ans = mutableListOf<Int>()

    for (i in p.indices) {
        if (freqMapP.containsKey(p[i])) {
            freqMapP[p[i]] = freqMapP[p[i]]!! + 1
        } else {
            freqMapP[p[i]] = 1
        }
        if (windowMap.containsKey(s[i])) {
            windowMap[s[i]] = windowMap[s[i]]!! + 1
        } else {
            windowMap[s[i]] = 1
        }
    }

    if (freqMapP == windowMap) ans.add(0)

    for (i in 1 until (s.length - p.length + 1)) {
        if (windowMap[s[i - 1]]!! == 1) {
            windowMap.remove(s[i - 1])
        } else {
            windowMap[s[i - 1]] = windowMap[s[i - 1]]!! - 1
        }
        if (windowMap.containsKey(s[i + p.length - 1])) {
            windowMap[s[i + p.length - 1]] = windowMap[s[i + p.length - 1]]!! + 1
        } else {
            windowMap[s[i + p.length - 1]] = 1
        }
        if (windowMap == freqMapP) ans.add(i)
    }
    for (an in ans) {
        println(an)
    }
}