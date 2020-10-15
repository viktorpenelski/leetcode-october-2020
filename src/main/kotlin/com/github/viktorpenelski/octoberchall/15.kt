package com.github.viktorpenelski.octoberchall

fun rotate(nums: IntArray, k: Int): Unit {

    val rotations = k % nums.size

    repeat(rotations) {
        var lastElement = nums[0]
        for (i in 1..nums.lastIndex) {
            val tmp = nums[i]
            nums[i] = lastElement
            lastElement = tmp
        }
        nums[0] = lastElement
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotate(nums, 3)
    nums.forEach { print("$it, ") }
}