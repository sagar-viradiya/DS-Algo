package leetcode

/*
    Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
    and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
    Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible.
    If the number of spaces on a line do not divide evenly between words,
    the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left justified and no extra space is inserted between words.

    Note:

        A word is defined as a character sequence consisting of non-space characters only.
        Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
        The input array words contains at least one word.

    Example 1:

    Input:
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]

    Example 2:

    Input:
    words = ["What","must","be","acknowledgment","shall","be"]
    maxWidth = 16
    Output:
    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be",
                 because the last line must be left-justified instead of fully-justified.
                 Note that the second line is also left-justified becase it contains only one word.

    Example 3:

    Input:
    words = ["Science","is","what","we","understand","well","enough","to","explain",
             "to","a","computer.","Art","is","everything","else","we","do"]
    maxWidth = 20
    Output:
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]
 */
fun main() {
    val words = arrayOf("What", "must", "be", "acknowledgment", "shall", "be")
    val maxWidth = 16

    val ans = mutableListOf<String>()

    var count: Int
    var index = 0
    var start: Int
    var noOfExtraSpaces: Int
    var noOfWords: Int
    while (index < words.size) {
        start = index
        count = words[index++].length + 1
        while (index < words.size && count + words[index].length + 1 <= maxWidth + 1) {
            count += words[index].length + 1
            index++
        }
        noOfExtraSpaces = maxWidth + 1 - count
        val s = StringBuffer()
        // If there is no extra space or it is last line just append each word with a space in between.
        if (noOfExtraSpaces == 0 || index == words.size) {
            for (i in start until index) {
                if (i == start) {
                    s.append(words[i])
                    continue
                }
                s.append(" ${words[i]}")
            }
            // If it is the last line append all extra spaces.
            if (index == words.size) {
                for (j in 0 until noOfExtraSpaces) {
                    s.append(' ')
                }
            }

        } else {
            noOfWords = index - start
            // If no of words are more than one then distribute space among all words.
            if (noOfWords > 1) {
                var remSpace = noOfExtraSpaces % (noOfWords - 1)
                val extraSpace = noOfExtraSpaces / (noOfWords - 1)

                for (i in start until index) {
                    if (i == start) {
                        s.append(words[i])
                        continue
                    }
                    if (remSpace > 0) {
                        for (j in 0 until extraSpace + 2) {
                            s.append(' ')
                        }
                    } else {
                        for (j in 0 until extraSpace + 1) {
                            s.append(' ')
                        }
                    }
                    if (remSpace > 0) remSpace--
                    s.append(words[i])
                }
            } else {
                // If there is only one word add all extra spaces at the end of the word.
                s.append(words[start])
                for (j in 0 until noOfExtraSpaces) {
                    s.append(' ')
                }
            }
        }
        ans.add(s.toString())
    }
    for (an in ans) {
        println(an)
    }
}