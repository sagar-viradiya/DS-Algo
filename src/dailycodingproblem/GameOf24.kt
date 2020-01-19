package dailycodingproblem

/*
    The 24 game is played as follows. You are given a list of four integers, each between 1 and 9, in a fixed order.
    By placing the operators +, -, *, and / between the numbers, and grouping them with parentheses,
    determine whether it is possible to reach the value 24.

    For example, given the input [5, 2, 7, 8], you should return True, since (5 * 2 - 7) * 8 = 24.

    Write a function that plays the 24 game.
 */
fun main() {
    val input = intArrayOf(5, 2, 7, 8)
    print(playGameOf24(input))
}

private fun playGameOf24(inputs: IntArray): Boolean {
    if (inputs.size == 1) return inputs[0] == 24
    if (inputs.size == 2) return applyOperations(inputs[0], inputs[1]).any { it == 24 }
    for (i in 0..inputs.size - 2) {
        applyOperations(inputs[i], inputs[i+1]).forEach {
            val result = when (i) {
                0 -> {
                    playGameOf24(intArrayOf(it) + inputs.copyOfRange(i+2, inputs.size))
                }
                inputs.size - 2 -> {
                    playGameOf24(inputs.copyOfRange(0, i) + it)
                }
                else -> {
                    playGameOf24(inputs.copyOfRange(0, i) + it + inputs.copyOfRange(i+2, inputs.size))
                }
            }
            if (result) return true
        }
    }
    return false
}

private fun applyOperations(a: Int, b: Int): IntArray {
    val result = intArrayOf(a+b, a*b, a-b)
    if (b != 0) return result + (a/b)
    return result
}