package dailycodingproblem

/*
    You are given a string consisting of the letters x and y, such as xyxxxyxyy. In addition,
    you have an operation called flip, which changes a single x to y or vice versa.

    Determine how many times you would need to apply this operation to ensure that all x's come before all y's.
    In the preceding example, it suffices to flip the second and sixth characters, so you should return 2.
 */
fun main() {
    val  input = "xxyxxxyyyyxy"
    val noOfyOnLeft = IntArray(input.length)
    val noOfxOnRight = IntArray(input.length)

    var noOfy = 0
    var noOfx = 0
    input.forEachIndexed { index, char ->
        noOfyOnLeft[index] = noOfy
        if (char == 'y') noOfy++
    }

    for (i in input.length - 1 downTo 0) {
        noOfxOnRight[i] = noOfx
        if (input[i] == 'x') noOfx++
    }

    var flips = Int.MAX_VALUE

    for (i in input.indices) {
        flips = minOf(flips, noOfxOnRight[i] + noOfyOnLeft[i])
    }
    print(flips)
}