package com.github.viktorpenelski.octoberchall

fun findPairs(nums: IntArray, k: Int): Int {

    // k: number to look for
    // v: number of times encountered
    val numsToLookFor: Map<Int, Int> = numsToLookFor(nums, k) // O(2N)

    val minMatchesExclusive = if (k == 0) {
        1
    } else {
        0
    }

    return numsToLookFor.asSequence() // O(N)
            .filter { it.value > minMatchesExclusive }
            .count()

    // time O(N)
    // space O(N)
    // N -> nums.length

}

fun numsToLookFor(nums: IntArray, k: Int): Map<Int, Int> {
    val answer = mutableMapOf<Int, Int>()

    for (num in nums) {
        val diff = num - k
        answer[diff] = 0
    }

    for (num in nums) {
        if (answer[num] != null) {
            answer[num] = answer[num]!! + 1
        }
    }

    return answer
}

fun main() {
    println(findPairs(intArrayOf(1, 2, 4, 4, 3, 3, 0, 9, 2, 3), 3))
    println(findPairs(intArrayOf(-1,-2,-3), 1))
    println(findPairs(intArrayOf(1,2,3,4,5), 1))
    println(findPairs(intArrayOf(1,3,1,5,4), 0))
}