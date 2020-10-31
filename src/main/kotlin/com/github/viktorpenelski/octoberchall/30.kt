package com.github.viktorpenelski.octoberchall

fun findNumberOfLIS(nums: IntArray): Int {

    var answer = 0
    var maxLen = 0
    val len = IntArray(nums.size)
    val count = IntArray(nums.size)
    for (i in nums.indices) {
        count[i] = 1
        len[i] = count[i]
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                if (len[i] == len[j] + 1) count[i] += count[j]
                if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1
                    count[i] = count[j]
                }
            }
        }
        if (maxLen == len[i]) {
            answer += count[i]
        } else if (maxLen < len[i]) {
            maxLen = len[i]
            answer = count[i]
        }
    }
    return answer
}


fun main() {
    println(findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7)))
    println(findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7)))
    println(findNumberOfLIS(intArrayOf(2, 2, 2, 2, 2)))
    println(findNumberOfLIS(intArrayOf(1, 2, 4, 3, 5, 4, 7, 2)))
}