package com.github.viktorpenelski.octoberchall

fun minDominoRotations(A: IntArray, B: IntArray): Int {

    // 6 sided dice encounters can fit the 1-6 index of a 7-sized array
    val encounters = IntArray(7)

    // count A and B separately, since otherwise we risk missing cases where both A and B have the same value
    val inA = IntArray(7)
    val inB = IntArray(7)

    for (i in 0..A.lastIndex) {

        // add an encounter of the respective value to both counting arrays
        val top = A[i]
        inA[top]++
        val bot = B[i]
        inB[bot]++

        // when values are different, add them both as encounters
        // otherwise, add the "singly" encountered value only once
        if (top != bot) {
            encounters[top]++
        }
        encounters[bot]++
    }

    for (i in 0..encounters.lastIndex) {
        // check if any encounter was found at least once in unique slots, guaranteed by the check above
        if (encounters[i] == A.size) {
            // if we find a solution, find the least amount of transfers, returning it as the answer
            // in case 2 valid solutions exist (e.g. case like [3,2,3], [2,3,2]), we don't care about the 2nd one,
            // because they mirror each other and the answer would be the same
            return Math.min(A.size - inA[i], A.size - inB[i])
        }
    }

    // if no solution was found, return -1
    return -1
}

fun main() {
    println(minDominoRotations(intArrayOf(2, 1, 2, 4, 2, 2), intArrayOf(5, 2, 6, 2, 3, 2)))
    println(minDominoRotations(intArrayOf(3, 5, 1, 2, 3), intArrayOf(3, 6, 3, 3, 4)))
}