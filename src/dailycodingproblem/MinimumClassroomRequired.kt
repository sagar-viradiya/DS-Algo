package dailycodingproblem


/*
    This problem was asked by Snapchat.

    Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
    find the minimum number of rooms required.

    For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
fun main() {
    val lectures = listOf(Pair(0, 75), Pair(75, 150), Pair(160, 170), Pair(170, 180))

    val mergedLectures = mutableListOf<Pair<Int, Int>>()

    outer@ for (lecture in lectures) {
        if (mergedLectures.isEmpty()) {
            mergedLectures.add(lecture)
            continue
        }
        for (i in 0 until mergedLectures.size) {
            //Check if lecture is not overlapping with one of the merged lecture.
            if (lecture.first >= mergedLectures[i].second || mergedLectures[i].first >= lecture.second) {
                mergedLectures[i] = Pair(
                        minOf(lecture.first, mergedLectures[i].first),
                        maxOf(lecture.second, mergedLectures[i].second)
                )
                continue@outer
            }
        }
        //If all merged lectures are overlapping with lecture then add it as a new entry in merged lectures.
        mergedLectures.add(lecture)
    }

    //Size of merged lectures is minimum no of classrooms required.
    print(mergedLectures.size)
}