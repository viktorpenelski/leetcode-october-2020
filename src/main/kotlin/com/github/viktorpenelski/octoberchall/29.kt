package com.github.viktorpenelski.octoberchall

fun maxDistToClosest(seats: IntArray): Int {

    // should be doable in O(1) space as well
    val maxFromLeft = IntArray(seats.size)
    for (i in 0..seats.lastIndex) {
        if (seats[i] == 0) {
            maxFromLeft[i] = if (i == 0) Int.MAX_VALUE else maxFromLeft[i - 1] + 1
        } else {
            maxFromLeft[i] = 0
        }
    }

    // can be done in a single pass, but will be harder to read
    val maxFromRight = IntArray(seats.size)
    for (i in seats.lastIndex downTo 0) {
        if (seats[i] == 0) {
            maxFromRight[i] = if (i == seats.lastIndex) Int.MAX_VALUE else maxFromRight[i + 1] + 1
        } else {
            maxFromRight[i] = 0
        }
    }

    var maxDistance = 0
    for (i in 0..seats.lastIndex) {
        maxDistance = Math.max(maxDistance, Math.min(maxFromLeft[i], maxFromRight[i]))
    }

    return maxDistance
}

fun main() {
    println(maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1)))
    println(maxDistToClosest(intArrayOf(1, 0, 0, 0)))
    println(maxDistToClosest(intArrayOf(0, 1)))
}