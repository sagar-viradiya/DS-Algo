package leetcode_may_challenge

/*
    You are a product manager and currently leading a team to develop a new product.
    Unfortunately, the latest version of your product fails the quality check.
    Since each version is developed based on the previous version, all the versions after a bad version are also bad.

    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

    You are given an API bool isBadVersion(version) which will return whether version is bad.
    Implement a function to find the first bad version. You should minimize the number of calls to the API.

    Example:

    Given n = 5, and version = 4 is the first bad version.

    call isBadVersion(3) -> false
    call isBadVersion(5) -> true
    call isBadVersion(4) -> true

    Then 4 is the first bad version.
 */

fun main() {
    val n = 2126753390

    var left = 0
    var right = n - 1
    var mid: Int
    var badVersion = 0
    while (left <= right) {
        mid = left + (right - left) / 2
        if (isBadVersion(mid + 1)) {
            badVersion = mid + 1
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    print(badVersion)
}

private fun isBadVersion(n: Int) = n >= 1702766719
