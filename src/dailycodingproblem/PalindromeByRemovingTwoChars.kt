package dailycodingproblem

/*
Given a string which we can delete at most k, return whether you can make a palindrome.

For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
 */
//DP problem
fun main(args: Array<String>) {
    val input = "waterrfetawx"
    val k = 2

    val cache = Array(input.length) {
        IntArray(input.length) { -1 }
    }

    print(canPalindrome(input.toCharArray(), k, 0, input.length - 1, cache))
}

private fun canPalindrome(input: CharArray, noOfIgnores: Int, start: Int, end: Int, cache: Array<IntArray>): Boolean {

    if (cache[start][end] != -1) {
        return cache[start][end] == 1
    } else if (input[start] == input[end]) {
        cache[start][end] = 1
        if (start + 1 <= end - 1) {
            return canPalindrome(input, noOfIgnores, start + 1, end -1, cache)
        }
        return true
    } else if (noOfIgnores == 0 && input[start] != input[end]) {
        cache[start][end] = 0
        return false
    } else {
        val result = canPalindrome(input, noOfIgnores - 1, start, end - 1, cache) ||
                canPalindrome(input, noOfIgnores - 1, start + 1, end, cache)
        cache[start][end] = if (result) 1 else 0
        return result
    }

}