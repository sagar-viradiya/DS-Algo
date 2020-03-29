package dailycodingproblem

import java.lang.StringBuilder
import java.util.*

/*
    This problem was asked by Flexport.

    Given a string s, rearrange the characters so that any two adjacent characters are not the same.
    If this is not possible, return null.

    For example, if s = yyz then return yzy. If s = yyy then return null.
 */

data class FrequencyCount(val char: Char, val frequency: Int) : Comparable<FrequencyCount> {
    override fun compareTo(other: FrequencyCount): Int {
        return when {
            this.frequency > other.frequency -> {
                1
            }
            this.frequency < other.frequency -> {
                -1
            }
            else -> {
                0
            }
        }
    }
}

fun main() {
    val input= "aabcdbaabbccd"
    val priorityQueue = PriorityQueue<FrequencyCount>()
    var previousChar = FrequencyCount('#', 0)

    val result = StringBuilder()

    val frequencyCount = mutableMapOf<Char, Int>()

    for (char in input) {
        if (frequencyCount[char] == null) {
            frequencyCount[char] = -1
            continue
        }
        frequencyCount[char] = frequencyCount[char]!! - 1
    }

    for (mutableEntry in frequencyCount) {
        priorityQueue.add(FrequencyCount(mutableEntry.key, mutableEntry.value))
    }
    var currentChar: FrequencyCount
    while (priorityQueue.isNotEmpty()) {
        currentChar = priorityQueue.poll()
        result.append(currentChar.char)
        currentChar = currentChar.copy(char = currentChar.char, frequency = currentChar.frequency + 1)
        if (previousChar.frequency != 0) {
            priorityQueue.add(previousChar)
        }
        previousChar = currentChar
    }

    if (input.length == result.length) {
        print(result)
    } else {
        print("Rearrangement not possible")
    }
}