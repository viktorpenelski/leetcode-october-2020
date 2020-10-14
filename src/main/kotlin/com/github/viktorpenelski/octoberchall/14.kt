package com.github.viktorpenelski.octoberchall

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]

    val robFirst = robSlice(nums, 0, nums.lastIndex)
    val robLast = robSlice(nums, 1, nums.size)
    return Math.max(robFirst, robLast)
}

private fun robSlice(nums: IntArray, start: Int, end: Int): Int {
    var rob = 0
    var notRob = 0
    for (i in start until end) {
        val maxSoFar = Math.max(rob, notRob + nums[i])
        notRob = rob
        rob = maxSoFar
    }
    return Math.max(rob, notRob)
}

