package kickstart2019.roundA

fun main() {
    val s = "51352341"
    var max = 0
    var start = 0
    var char: Char
    val charMap = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        char = s[i]
        if (charMap[char] != null && charMap[char]!! >= start) {
            start = charMap[char]!! + 1
        }
        charMap[char] = i
        max = kotlin.math.max(max, i - start + 1)
    }
    print(max)
}