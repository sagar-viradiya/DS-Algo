package leetcode

import java.util.*

/*
    Given a grid of server where each cell represents a server with a state either '1' or '0'.
    Server having state '1' has a file and '0' without file.

    Given an initial configuration of servers, After 1 hour server having file can send file to adjacent server
    (left, right, top and bottom). Find the minimum number of hours required to send file to all server.
    If all server can't get file at all then return -1.

    e.g
    If the initial configuration of a server grid is
    [[0, 1, 1, 0, 1],
     [0, 1, 0, 1, 0],
     [0, 0, 0, 0, 1],
     [0, 1, 0, 0, 0]]

     Minimum number of hours required to send file to all servers would be 2.

    If the initial configuration of a server grid is
    [[0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0]]

     There is no way all server will get file so return -1.
 */

//BFS approach
fun main() {
    val serverGrid = arrayOf(
            intArrayOf(0, 1, 1, 0, 1),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 0, 1),
            intArrayOf(0, 1, 0, 0, 0))

    val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
    var minNumberOfHours = 0
    var target = 0
    val queue = ArrayDeque<Pair<Int, Int>>()

    for (i in serverGrid.indices) {
        for (j in serverGrid[i].indices) {
            if (serverGrid[i][j] == 1) {
                queue.add(Pair(i, j))
                target++
            }
        }
    }

    if (queue.isEmpty()) {
        print(-1)
        return
    }

    var positionX: Int
    var positionY: Int
    while (queue.isNotEmpty() && target != serverGrid.size * serverGrid[0].size) {
        for (pair in queue) {
            for (direction in directions) {
                positionX = direction.first + pair.first
                positionY = direction.second + pair.second
                if (positionX in serverGrid.indices
                        && positionY in serverGrid[0].indices
                        && serverGrid[positionX][positionY] == 0) {
                    queue.add(Pair(positionX, positionY))
                    serverGrid[positionX][positionY] = 1
                    target++
                }
            }
        }
        minNumberOfHours++
    }

    print(minNumberOfHours)
}

