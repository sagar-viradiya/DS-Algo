package dailycodingproblem

/*
    This problem was asked by Microsoft.

    You are given a list of jobs to be done, where each job is represented by a start time and end time.
    Two jobs are compatible if they don't overlap. Find the largest subset of compatible jobs.

    For example, given the following jobs (there is no guarantee that jobs will be sorted):

    [(0, 6),
    (1, 4),
    (3, 5),
    (3, 8),
    (4, 7),
    (5, 9),
    (6, 10),
    (8, 11)]

    Return:

    [(1, 4),
    (4, 7),
    (8, 11)]

 */

class Job(val start: Int, val end: Int = -1) : Comparable<Job> {
    override fun compareTo(other: Job): Int {
        return when {
            this.end > other.end -> 1
            this.end < other.end -> -1
            else -> 0
        }
    }
}

/*
    Greedy approach
    https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 */
fun main() {
    val jobs = arrayOf(
            Pair(0, 6),
            Pair(1, 4),
            Pair(3, 5),
            Pair(3, 8),
            Pair(4, 7),
            Pair(5, 9),
            Pair(5, 6),
            Pair(6, 10),
            Pair(6, 8),
            Pair(8, 11))

    //Sort all jobs by end time.
    val jobList = jobs.map { Job(it.first, it.second) }.sorted()

    val scheduling = mutableListOf(jobList[0])

    var previousJob = jobList[0]

    for (i in 1 until jobList.size) {
        if (previousJob.end <= jobList[i].start) {
            previousJob = jobList[i]
            scheduling.add(jobList[i])
        }
    }

    scheduling.forEach { println("${it.start}, ${it.end}") }
}