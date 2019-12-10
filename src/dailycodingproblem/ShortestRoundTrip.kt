package dailycodingproblem

/*
    A competitive runner would like to create a route that starts and ends at his house,
    with the condition that the route goes entirely uphill at first, and then entirely downhill.

    Given a dictionary of places of the form {location: elevation},
    and a dictionary mapping paths between some of these locations to their corresponding distances,
    find the length of the shortest route satisfying the condition above. Assume the runner's home is location 0.

    For example, suppose you are given the following input:

    elevations = {0: 5, 1: 25, 2: 15, 3: 20, 4: 10}
    paths = {
        (0, 1): 10,
        (0, 2): 8,
        (0, 3): 15,
        (1, 3): 12,
        (2, 4): 10,
        (3, 4): 5,
        (3, 0): 17,
        (4, 0): 10
    }
    In this case, the shortest valid path would be 0 -> 2 -> 4 -> 0, with a distance of 28.
 */
fun main() {
    val places: Map<Int, Int> = mapOf(0 to 5, 1 to 25, 2 to 15, 3 to 20, 4 to 10)
    val paths: Map<Pair<Int, Int>, Int> = mapOf(Pair(0, 1) to 10, Pair(0, 2) to 8, Pair(0, 3) to 15, Pair(1, 3) to 12,
            Pair(2, 4) to 10, Pair(3, 4) to 5, Pair(3, 0) to 17, Pair(4, 0) to 10)

    val modifiedPaths: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
    paths.entries.forEach {
        if (modifiedPaths[it.key.first] == null) {
            modifiedPaths[it.key.first] = mutableListOf(Pair(it.key.second, it.value))
        } else {
            modifiedPaths[it.key.first]!!.add(Pair(it.key.second, it.value))
        }
    }
    print(findShortestPath(places, modifiedPaths))

}

//Recursive solution
private fun findShortestPath(places: Map<Int, Int>, paths: Map<Int, List<Pair<Int, Int>>>, start: Int = 0): Int {
    if (start == 0) {
        val validPaths = paths[start]!!.filter { places[it.first]!! > places[start]!! }
        if (validPaths.isEmpty()) return Int.MAX_VALUE
        return validPaths.map { it.second + findShortestPath(places, paths, it.first) }.min() ?: Int.MAX_VALUE
    } else {
        val validPaths = paths[start]!!.filter { places[it.first]!! < places[start]!! }
        if (validPaths.isEmpty()) return Int.MAX_VALUE
        return validPaths.map { if (it.first == 0) it.second else it.second + findShortestPath(places, paths, it.first) }.min()
                ?: Int.MAX_VALUE
    }
}