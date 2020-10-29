package com.github.viktorpenelski.octoberchall

import java.util.ArrayDeque

fun find132pattern(nums: IntArray): Boolean {
    if (nums.size < 3) return false

    var sec = Int.MIN_VALUE
    val deq = ArrayDeque<Int>()

    for (i in nums.lastIndex downTo 0) {
        if (nums[i] < sec) return true

        while (deq.isNotEmpty() && nums[i] > deq.peekLast()) {
            sec = deq.pollLast()
        }
        deq.addLast(nums[i])
    }

    return false
}

fun main() {
    println(find132pattern(intArrayOf(1,-4,2,-1,3,-3,-4,0,-3,-1)))
}