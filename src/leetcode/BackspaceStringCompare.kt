package leetcode

/*
    Given two strings S and T, return if they are equal when both are typed into empty text editors.
    # means a backspace character.

    Example 1:

    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".

    Example 2:

    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".

    Example 3:

    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".

    Example 4:

    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".

    Note:

        1 <= S.length <= 200
        1 <= T.length <= 200
        S and T only contain lowercase letters and '#' characters.

    Follow up:

        Can you solve it in O(N) time and O(1) space?

 */
fun main() {
    val S = "bxj##tw"
    val T = "bxo#j##tw"

    var i = S.length - 1
    var j = T.length - 1

    var skipS = 0
    var skipT = 0

    while (i >= 0 || j >= 0) {
        outer1@ while (i >= 0) {
            when {
                S[i] == '#' -> {
                    skipS++
                    i--
                }
                skipS > 0 -> {
                    skipS--
                    i--
                }
                else -> break@outer1
            }
        }

        outer2@ while (j >= 0) {
            when {
                T[j] == '#' -> {
                    skipT++
                    j--
                }
                skipT > 0 -> {
                    skipT--
                    j--
                }
                else -> break@outer2
            }
        }

        if (i >= 0 && j >= 0 && S[i] != T[j]) {
            print(false)
            return
        }

        if ((i >= 0) != (j >= 0)) {
            print(false)
            return
        }
        i--
        j--
    }

    print(true)

}