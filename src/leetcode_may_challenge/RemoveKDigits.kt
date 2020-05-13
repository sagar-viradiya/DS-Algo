package leetcode_may_challenge

import java.lang.StringBuilder
import java.util.*

/*
    Given a non-negative integer num represented as a string,
    remove k digits from the number so that the new number is the smallest possible.

    Note:

        The length of num is less than 10002 and will be ≥ k.
        The given num does not contain any leading zero.

    Example 1:

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    Example 2:

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

    Example 3:

    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */
fun main() {
    val num = "10200"
    val k = 1

    if (k == 0) {
        print(num)
        return
    }

    if (num.length == k) {
        print("0")
        return
    }

    var n = k

    val stack = Stack<Int>()

    for (char in num) {
        while (!stack.isEmpty() && n > 0 && stack.peek() > Character.getNumericValue(char)) {
            stack.pop()
            n--
        }
        stack.push(Character.getNumericValue(char))
    }

    while (n != 0) {
        stack.pop()
        n--
    }

    val result = StringBuilder()
    var ignore = true
    for (i in 0 until stack.size) {
        if (stack[i] != 0) {
            ignore = false
            result.append(stack[i])
        } else if (!ignore) {
            result.append(stack[i])
        }
    }

    if (result.isBlank()) print("0") else print(result)
}