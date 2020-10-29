package com.github.viktorpenelski.octoberchall

fun summaryRanges(nums: IntArray): List<String> {

    if (nums.isEmpty()) return emptyList()
    if (nums.size == 1) return listOf(nums[0].toString())

    var start = 0
    var idx = 0

    val answer = mutableListOf<String>()

    while (idx < nums.size) {
        if (idx + 1 < nums.size && nums[idx] + 1 == nums[idx + 1]) {
            idx++
        } else {
            if (start == idx) {
                answer.add(nums[start].toString())
            } else {
                answer.add("${nums[start]}->${nums[idx]}")
            }
            idx += 1
            start = idx
        }
    }

    return answer
}

fun main() {
    summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)).forEach { println(it) }
    summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)).forEach { println(it) }
}