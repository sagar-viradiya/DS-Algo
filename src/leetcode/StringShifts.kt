package leetcode

/*
    You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

    direction can be 0 (for left shift) or 1 (for right shift).
    amount is the amount by which string s is to be shifted.
    A left shift by 1 means remove the first character of s and append it to the end.
    Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.

    Return the final string after all operations.

    Example 1:

    Input: s = "abc", shift = [[0,1],[1,2]]
    Output: "cab"
    Explanation:
    [0,1] means shift to left by 1. "abc" -> "bca"
    [1,2] means shift to right by 2. "bca" -> "cab"

    Example 2:

    Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
    Output: "efgabcd"
    Explanation:
    [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
    [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
    [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
    [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"

    Hint:
    You may notice that left shift cancels the right shift,
    so count the total left shift times (may be negative if the final result is right shift), and perform it once.

 */
fun main() {
    val s = "ab"
    val shifts = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(1, 3))

    var numberOfShifts = 0

    for (shift in shifts) {
        if (shift[0] == 0) {
            numberOfShifts += shift[1]
        } else {
            numberOfShifts -= shift[1]
        }
    }

    val charArray = CharArray(s.length)
    if (numberOfShifts > 0) {
        numberOfShifts %= s.length
        for (i in 0 until numberOfShifts) {
            charArray[s.length - numberOfShifts + i] = s[i]
        }

        for (j in numberOfShifts until s.length) {
            charArray[j - numberOfShifts] = s[j]
        }
    } else if (numberOfShifts < 0) {
        numberOfShifts = -numberOfShifts % s.length
        var tempIndex = numberOfShifts
        for (i in s.length - 1 downTo s.length - numberOfShifts) {
            charArray[--tempIndex] = s[i]
        }
        for (j in 0 until s.length - numberOfShifts) {
            charArray[j + numberOfShifts] = s[j]
        }
    }

    print(String(charArray))
}