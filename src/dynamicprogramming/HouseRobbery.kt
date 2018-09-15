package dynamicprogramming

/*

    There are n houses build in a line, each of which contains some value in it.
    A thief is going to steal the maximal value of these houses,
    but he can’t steal in two adjacent houses because owner of the stolen houses will tell his two neighbour left and right side.
    What is the maximum stolen value.

    Input  : {5, 3, 4, 11, 2}
    Output : 16
    Thief will steal 5 and 11

*/

fun main(args: Array<String>) {
    val money = intArrayOf(5, 3, 4, 11, 2)
    val caching = IntArray(money.size) { -1 }
    println(maximizeRobbery(0, money, caching))
    print(maximizeRobbery(money))
}

private fun maximizeRobbery(start: Int, money: IntArray, caching: IntArray): Int {

    if (start == money.size - 1) {
        return money[start]
    }

    if (start == money.size - 2) {
        return maxOf(money[start], money[money.size - 1])
    }

    if (start == money.size - 3) {
        return  maxOf(money[start +  1], money[start] + money[start + 2])
    }

    if (caching[start] != -1) {
        return caching[start]
    }

    caching[start] = maxOf(money[start] + maximizeRobbery(start + 2, money, caching),
            money[start + 1] + maximizeRobbery(start + 3, money, caching))

    return caching[start]

}

//Bottom up approach
private fun maximizeRobbery(money: IntArray): Int {

    if (money.size == 1) {
        return money[0]
    }

    if (money.size == 2) {
        return maxOf(money[0], money[1])
    }

    val robberies = IntArray(money.size)
    robberies[0] = money[0]
    robberies[1] = maxOf(money[0], money[1])

    for (i in 2 until money.size) {
        robberies[i] = maxOf(money[i] + robberies[i - 2], robberies[i - 1])
    }

    return robberies[money.size - 1]

}