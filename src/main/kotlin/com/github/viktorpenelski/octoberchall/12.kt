package com.github.viktorpenelski.octoberchall

fun buddyStrings(A: String, B: String): Boolean {
    if (A.length != B.length) return false

    val aChars = A.asSequence()
            .groupBy { it }
            .mapValues { it.value.size }
            .toMap()

    val bChars = B.asSequence()
            .groupBy { it }
            .mapValues { it.value.size }
            .toMap()

    for (c in aChars.keys) {
        if (aChars[c] != bChars[c]) return false
    }

    if (A == B) {
        return aChars.filter { it.value > 1 }.isNotEmpty()
    }

    var count = 0
    for (i in 0..A.lastIndex) {
        if (A[i] != B[i]) {
            count++
        }
        if (count > 2) return false
    }

    return count == 2
}

fun main() {

}