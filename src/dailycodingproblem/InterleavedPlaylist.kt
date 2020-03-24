package dailycodingproblem

import java.util.ArrayDeque

/*
    This problem was asked by Spotify.

    You have access to ranked lists of songs for various users. Each song is represented as an integer,
    and more preferred songs appear earlier in each list. For example, the list [4, 1, 7] indicates that a user likes song 4 the best,
    followed by songs 1 and 7.

    Given a set of these ranked lists, interleave them to create a playlist that satisfies everyone's priorities.

    For example, suppose your input is {[1, 7, 3], [2, 1, 6, 7, 9], [3, 9, 5]}. In this case a satisfactory playlist could be [2, 1, 6, 7, 3, 9, 5].
 */

/*
    The first step to solving this problem is to organize the input in a more helpful way.
    Ideally we would like some data structure that tells us what songs come before other songs.
    A sensible approach will be to iterate over each list and populate a map from songs to their direct successors.

    Applying this approach to the input lists, we would end up with the following dictionary:

    prev_to_next = {1: [7, 6], 7: [3, 9], 2: [1], 6: [7]}, 3: [9], 9: [5]}.

    We can iterate over the values of this dictionary to find out how many predecessors each song has.
    Any songs that do not appear in one of the list of values will be eligible to start our playlist.
    The resulting previous count map for the input above will be as follows:

    prev_count = {7: 2, 3: 1, 1: 1, 6: 1, 9: 2, 5: 1}

    Finally we reach the core of our algorithm. We will create a queue which represents our playlist,
    and initially populate it with the songs without any predecessors. While this queue is not empty,
    we pop the first item and get its successors. For each successor, we must decrement its value in prev_count,
    since one dependency has just been removed.

    If a successor has no other songs that come before it (in other words, if its value in prev_count is zero),
    we can safely append it to the queue and playlist. Otherwise, we continue to the next item in the queue.

    Let's look at a few steps of how this would play out for our input. Initially,
    our queue and playlist will begin with 2. We pop this item and get its sole successor, 1,
    and decrement its count in prev_count. Since its count is now zero, indicating that it has no other predecessors,
    we will add it to our queue and playlist.

    Next, we get the successors of 1, which are 7 and 6, and decrement their counts.
    Song 6 is free to add to our queue and playlist, since it has no other predecessors. However,
    we do nothing more with 7 for the moment, since we know there is some other song we must play before adding it.

    After exhausting our queue in this manner, we return the resulting playlist.
 */

fun main() {
    val playlists = arrayOf(
            intArrayOf(1, 7, 3),
            intArrayOf(2, 1, 6, 7, 9),
            intArrayOf(3, 9, 5))

    val predecessor = mutableMapOf<Int, MutableList<Int>>()
    val noOfSuccessors = mutableMapOf<Int, Int>()
    val interleavedPlaylist = mutableListOf<Int>()

    for (playlist in playlists) {
        for (i in 0 until playlist.size - 1) {
            if (predecessor[playlist[i]] == null) {
                predecessor[playlist[i]] = mutableListOf()
            }
            predecessor[playlist[i]]!!.add(playlist[i+1])
        }
    }

    for (mutableEntry in predecessor) {
        for (i in mutableEntry.value) {
            if (noOfSuccessors[i] == null) {
                noOfSuccessors[i] = 1
                continue
            }
            noOfSuccessors[i] = noOfSuccessors[i]!! + 1
        }
    }

    val queue = ArrayDeque<Int>()

    for (playlist in playlists) {
        for (song in playlist) {
            if (song !in noOfSuccessors) {
                queue.add(song)
                interleavedPlaylist.add(song)
            }
        }
    }

    var tempSong = 0
    while (queue.isNotEmpty()) {
        tempSong = queue.remove()
        if (predecessor[tempSong] != null) {
            for (nextSongs in predecessor[tempSong]!!) {
                noOfSuccessors[nextSongs] = noOfSuccessors[nextSongs]!! - 1
                if (noOfSuccessors[nextSongs] == 0) {
                    queue.add(nextSongs)
                    interleavedPlaylist.add(nextSongs)
                }
            }
        }
    }

    print(interleavedPlaylist.toString())
}