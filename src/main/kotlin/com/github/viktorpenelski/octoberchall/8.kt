package com.github.viktorpenelski.octoberchall

import java.util.*

fun search(nums: IntArray, target: Int): Int {

    // -1,0,3,5,9,12  /9
    //      %
    //          %

    // -1,0,3,5,9,12  /0
    //      %

    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val midPoint = start + ((end - start) / 2)

        val midNum = nums[midPoint]

        if (midNum == target) {
            return midPoint
        }
        if (midNum < target) {
            start = midPoint + 1
        } else {
            end = midPoint - 1
        }
    }

    return -1
}

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), -1))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 12))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 10))
}