package dailycodingproblem
/*
    A fixed point in an array is an element whose value is equal to its index. Given a sorted array of distinct elements,
    return a fixed point, if one exists. Otherwise, return False.

    For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return False.
 */
fun main() {
    val input = intArrayOf(1, 5, 7, 40)

    var left = 0
    var right = input.size - 1
    var mid = (left + right) / 2

    while (left < right) {
        if (input[mid] == mid) {
            print(mid)
            return
        }
        if (input[mid] > mid) {
            right = mid - 1
            mid = (left + right) / 2
        } else {
            left = mid + 1
            mid = (left + right) / 2
        }
    }

    print("No fix point")

}