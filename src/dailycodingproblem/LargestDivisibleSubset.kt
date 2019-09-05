package practice

/*
    Given a set of distinct positive integers, find the largest subset such that every pair of elements in the subset (i, j)
    satisfies either i % j = 0 or j % i = 0.

    For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. Given [1, 3, 6, 24], return [1, 3, 6, 24].
 */

fun main() {
    val nums = intArrayOf(2, 3, 5)
    val ansIndex = IntArray(nums.size)
    var max = 0
    var maxCount = 1
    var maxIndex = -1
    var start = -1
    val ans = mutableListOf<Int>()


    if (nums.size > 1) {
        nums.sort()
        val temp = IntArray(nums.size)
        ansIndex[nums.size - 1] = -1
        temp[nums.size - 1] =  1
        for (i in nums.size - 2 downTo 0) {
            max = 0
            maxIndex = -1
            for (j in i + 1 until nums.size) {
                if (nums[j] % nums[i] == 0) {
                    if (max < temp[j]) {
                        max = temp[j]
                        maxIndex = j
                    }
                }
            }
            temp[i] = max + 1
            ansIndex[i] = maxIndex
            if (maxCount < temp[i]) {
                maxCount = temp[i]
                start = i
            }
        }
    }

    if (start != -1) {
        do {
            ans.add(nums[start])
            start = ansIndex[start]
        } while (start != -1)
    } else if (nums.isNotEmpty()) {
        ans.add(nums[0])
    }

    print(ans.toString())

}