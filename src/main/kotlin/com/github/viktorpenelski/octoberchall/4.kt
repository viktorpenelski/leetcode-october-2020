package com.github.viktorpenelski.octoberchall

private fun removeCoveredIntervals(intervals: Array<IntArray>): Int {

    var answer = 0
    for (i in intervals.indices) {
        var isCovered = false
        val current = intervals[i]
        for (j in intervals.indices) {
            if (i == j) continue
            val compared = intervals[j]
            if (compared[0] <= current[0] && current[1] <= compared[1]) {
                isCovered = true
                break
            }
        }
        if (!isCovered) answer++
    }

    return answer
}

fun main() {
    println(removeCoveredIntervals(arrayOf(
            intArrayOf(1,4),
            intArrayOf(3,4),
            intArrayOf(1,2)
    )))
}