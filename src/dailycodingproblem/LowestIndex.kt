package dailycodingproblem

/*
    Given a sorted array arr of distinct integers, return the lowest index i for which arr[i] == i.
    Return -1 if there is no such index.

    For example, given the array [-5, -3, 2, 3], return 2 since arr[2] == 2. Even though arr[3] == 3,
    we return 2 since it's the lowest index.
 */
fun main() {
    val array = intArrayOf(-5, -3, 2, 3)
    print(getLowestFixedIndex(0, array.size, array))
}

//Binary search technique.
private fun getLowestFixedIndex(start: Int, end: Int, array: IntArray): Int {
    if (end >= start) {
        val mid = (start + end) / 2
        return when {
            mid == array[mid] -> {
                mid
            }
            mid > array[mid] -> {
                getLowestFixedIndex(mid + 1, end, array)
            }
            else -> {
                getLowestFixedIndex(start, mid - 1, array)
            }
        }
    }
    return -1
}