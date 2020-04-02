package leetcode

/*
    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer,
    replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
    or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Example:

    Input: 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
 */
fun main() {
    val n = 19
    var  num = n
    if (num == 1) {
        print(true)
        return
    }
    val seen = mutableMapOf<Int, Boolean>()
    seen[num] = true

    do {
        num = getSumOfSquareOfDigit(num)
        if (seen[num] != null) {
            print(false)
            break
        }
        seen[num] = true
    } while (num != 1)

    print(true)

}

private fun getSumOfSquareOfDigit(num: Int): Int {
    if (num < 10) return num * num
    val lastDigit = num % 10
    return (lastDigit * lastDigit) + getSumOfSquareOfDigit(num/10)
}