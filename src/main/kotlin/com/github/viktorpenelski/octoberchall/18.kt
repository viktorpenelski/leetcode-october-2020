package com.github.viktorpenelski.octoberchall

class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        if (k >= prices.size) {
            return climbingMax(k, prices)
        }

        return bottomUp(k, prices)
    }

    private fun climbingMax(k: Int, prices: IntArray): Int {
        var max = 0
        for(i in 1..prices.lastIndex) {
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1]
            }
        }
        return max
    }

    private fun bottomUp(k: Int, prices: IntArray): Int {
        val buy = IntArray(k+1) { Int.MIN_VALUE }
        var sell = IntArray(k+1)

        for (price in prices) {
            for (i in 1..k) {
                buy[i] = Math.max(buy[i], sell[i-1] - price)
                sell[i] = Math.max(sell[i], buy[i] + price)
            }
        }
        return sell[k]
    }
}