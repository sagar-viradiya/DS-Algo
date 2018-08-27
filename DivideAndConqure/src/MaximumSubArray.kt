/**
 * Maximum sub array problem
 *
 * Given an array of integers find the sub array whose sum is maximum
 */

fun main(args: Array<String>) {

    val array = intArrayOf(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7)
    print(getMaximumSubArray(array, 0, array.size - 1))

}

fun getMaximumSubArray(array: IntArray, low: Int, high: Int) : MaximumTuple {

    if (low == high) {
        return MaximumTuple(low, high, array[low])
    } else {
        val mid = (low + high) / 2
        val maxLeft = getMaximumSubArray(array, low, mid)
        val maxRight = getMaximumSubArray(array, mid + 1, high)
        val maxCross = getMaximumCrossSubArray(array, low, mid, high)

        return if (maxLeft.sum >= maxRight.sum && maxLeft.sum >= maxCross.sum) {
            maxLeft
        } else if(maxRight.sum >= maxLeft.sum && maxRight.sum >= maxCross.sum) {
            maxRight
        } else {
            maxCross
        }
    }

}

fun getMaximumCrossSubArray(array: IntArray, low: Int, mid: Int, high: Int) : MaximumTuple {

    var leftMaxSum: Int? = null
    var rightMaxSum: Int? = null

    var leftIndex = 0
    var rightIndex = 0

    var sum = 0

    for (i in mid downTo low) {
        sum += array[i]
        if (leftMaxSum == null || leftMaxSum < sum) {
            leftMaxSum = sum
            leftIndex = i
        }
    }

    sum = 0

    for (j in mid + 1..high) {
        sum += array[j]
        if (rightMaxSum == null || rightMaxSum < sum) {
            rightMaxSum = sum
            rightIndex = j
        }
    }

    return MaximumTuple(leftIndex, rightIndex, (leftMaxSum!! + rightMaxSum!!))

}


data class MaximumTuple(val low: Int, val high: Int, val sum: Int)
//Output will be MaximumTuple(low=7, high=10, sum=43)