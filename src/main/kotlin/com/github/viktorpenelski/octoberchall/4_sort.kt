package com.github.viktorpenelski.octoberchall

import java.util.*

private fun removeCoveredIntervals(intervals: Array<IntArray>): Int {

    Arrays.sort(intervals) { a: IntArray, b: IntArray ->
        if (a[0] == b[0]) {
            b[1] - a[1]
        } else {
            a[0] - b[0]
        }
    }

    var answer = intervals.size
    var last = intervals[0]
    for (i in 1..intervals.lastIndex) {
        val current = intervals[i]
        if (last[0] <= current[0] && current[1] <= last[1]) {
            answer--
        } else {
            last = current
        }
    }

    return answer
}

fun main() {
    println(removeCoveredIntervals(arrayOf(
            intArrayOf(1, 4),
            intArrayOf(3, 4),
            intArrayOf(1, 2)
    )))
}
