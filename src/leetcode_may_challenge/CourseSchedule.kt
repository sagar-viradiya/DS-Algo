package leetcode_may_challenge

/*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
    which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    Example 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
                 To take course 1 you should have finished course 0. So it is possible.

    Example 2:

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
                 To take course 1 you should have finished course 0, and to take course 0 you should
                 also have finished course 1. So it is impossible.

    Constraints:

        The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
        You may assume that there are no duplicate edges in the input prerequisites.
        1 <= numCourses <= 10^5
 */

val visitedCourses = mutableSetOf<Int>()

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(intArrayOf(0, 1), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(3, 4))
    // Graph representation of input
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    // Build graph from inputs
    for (prerequisite in prerequisites) {
        if (graph.containsKey(prerequisite[0])) {
            graph[prerequisite[0]]!!.add(prerequisite[1])
            continue
        }
        graph[prerequisite[0]] = mutableSetOf(prerequisite[1])
    }
    // Run DFS on all components of graph in case graph is not connected.
    for (i in 0 until numCourses) {
        if (!visitedCourses.contains(i) && containsCycle(i, graph)) {
            print(false)
            return
        }
    }
    print(true)
}

/**
 * DFS to check cycle in the graph
 * @param currentCourses To check all the courses visited in the current call stack. If it contains [course] that means
 * there is cycle in the graph.
 */
private fun containsCycle(course: Int, graph: Map<Int, Set<Int>>, currentCourses: MutableSet<Int> = mutableSetOf()): Boolean {
    if (currentCourses.contains(course)) return true
    currentCourses.add(course)
    if (graph[course] == null) {
        visitedCourses.add(course)
        currentCourses.remove(course)
        return false
    }
    graph[course]!!.forEach {
        if (!visitedCourses.contains(it) && containsCycle(it, graph, currentCourses)) return true
    }
    visitedCourses.add(course)
    currentCourses.remove(course)
    return false
}