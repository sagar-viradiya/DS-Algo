package leetcode_may_challenge

/*
    Given a non negative integer number num.
    For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

    Example 1:

    Input: 2
    Output: [0,1,1]

    Example 2:

    Input: 5
    Output: [0,1,1,2,1,2]

    Follow up:
        It is very easy to come up with a solution with run time O(n*sizeof(integer)).
        But can you do it in linear time O(n) /possibly in a single pass?
        Space complexity should be O(n).
    https://youtu.be/yU1EnHZWscU
 */
fun main() {
    val nums = 5
    val ans = IntArray(nums + 1)
    for (i in 1..nums) {
        ans[i] = ans[(i and (i - 1))] + 1
    }

    for (an in ans) {
        print("$an ")
    }
}