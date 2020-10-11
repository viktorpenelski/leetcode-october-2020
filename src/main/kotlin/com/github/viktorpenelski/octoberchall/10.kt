package com.github.viktorpenelski.octoberchall

import java.util.*

fun findMinArrowShots(points: Array<IntArray>): Int {

    if (points.isEmpty()) return 0

    Arrays.sort(points) { b1, b2 -> b1[1] - b2[1] }
    val balloons = points.map { Balloon(it[0], it[1]) }

    var end = balloons[0].end
    var arrows = 1

    for (i in 1..points.lastIndex) {
        val balloon = balloons[i]
        if (end.isNotWithin(balloon)) {
            arrows++
            end = balloon.end
        }
    }

    return arrows
}

private fun Int.isWithin(b: Balloon): Boolean {
    return this >= b.start && this <= b.end
}

private fun Int.isNotWithin(b: Balloon): Boolean {
    return !this.isWithin(b)
}

data class Balloon(
        val start: Int,
        val end: Int
)