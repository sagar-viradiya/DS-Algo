package leetcode

/*
    Given a list of words, each word consists of English lowercase letters.

    Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.
    For example, "abc" is a predecessor of "abac".

    A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

    Return the longest possible length of a word chain with words chosen from the given list of words.

    Example 1:

    Input: ["a","b","ba","bca","bda","bdca"]
    Output: 4
    Explanation: one of the longest word chain is "a","ba","bda","bdca".
 */
fun main() {
    val words = arrayOf("ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru")

    val results = MutableList(words.size) { 0 }
    var maxLength = 0
    for (i in words.indices) {
        maxLength = if (results[i] == 0) {
            maxOf(maxLength, getWordChainCount(words[i], words, i, results))
        } else {
            maxOf(maxLength, results[i])
        }
    }
    print(maxLength)
}

private fun getWordChainCount(word: String, wordArray: Array<String>, position: Int, cache: MutableList<Int>): Int {
    if (cache[position] != 0) return cache[position]

    cache[position] = (wordArray.indices
            .filter { wordArray[it].length == word.length + 1 && canChain(wordArray[it], word)}
            .map { getWordChainCount(wordArray[it], wordArray, it, cache) }.max() ?: 0) + 1

    return cache[position]
}

private fun canChain(word1: String, word2: String): Boolean {
    var maybe: String
    for (i in word1.indices) {
        maybe = word1.substring(0, i) + word1.substring(i+1)
        if (maybe == word2) return true
    }
    return false
}