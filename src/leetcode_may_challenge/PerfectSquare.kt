package leetcode_may_challenge

/*
    Given a positive integer num, write a function which returns True if num is a perfect square else False.
    Note: Do not use any built-in library function such as sqrt.
 */
fun main() {
    val num = 16

    if (num == 0 || num == 1) {
        print(true)
        return
    }

    val longNum = num.toLong()
    var t = longNum / 2
    while (t * t > longNum) {
        t = (t + longNum / t) / 2
    }
    print(t * t == longNum)
}