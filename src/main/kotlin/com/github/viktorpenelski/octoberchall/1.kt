package com.github.viktorpenelski.octoberchall

/**
 *
 * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3480/
 *
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */
@ExperimentalStdlibApi
class RecentCounter {

    private val history: ArrayDeque<Int> = ArrayDeque()

    fun ping(t: Int): Int {

        history.addLast(t)
        var max: Int = history.first()
        while (max < t - 3000) {
            history.removeFirst()
            max = history.first()
        }

        return history.size
    }

}

@ExperimentalStdlibApi
fun main() {
    val counter = RecentCounter()
    println(counter.ping(1))
    println(counter.ping(100))
    println(counter.ping(3001))
    println(counter.ping(3002))
}