package dailycodingproblem

/*
    This problem was asked by Robinhood.

    Given an array of strings, group anagrams together.

    For example, given the following array:

    ['eat', 'ate', 'apt', 'pat', 'tea', 'now']

    Return:

    [['eat', 'ate', 'tea'],
     ['apt', 'pat'],
     ['now']]
 */
fun main() {
    val words = arrayOf("apt","man","qom","apt","lei","hus","pet","gay","six","mai")

    val anagramGroup = mutableMapOf<String, MutableList<String>>()
    var sortedString: String
    var charArray: CharArray
    for (word in words) {
        charArray = word.toCharArray()
        charArray.sort()
        sortedString = charArray.joinToString()
        if (anagramGroup[sortedString] == null) {
            anagramGroup[sortedString] = mutableListOf(word)
            continue
        }
        anagramGroup[sortedString]!!.add(word)
    }

    print(anagramGroup.map { it.value }.toString())
}