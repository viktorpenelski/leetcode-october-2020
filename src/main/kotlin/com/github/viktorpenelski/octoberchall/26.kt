package com.github.viktorpenelski.octoberchall

fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {

    val dp = Array(query_row + 2) { DoubleArray(query_row + 2) }

    dp[0][0] = poured.toDouble()
    for (row in 0..query_row) {
        for (glass in 0..row) {
            if (dp[row][glass] > 1) {
                val flow = dp[row][glass] - 1
                dp[row + 1][glass] += flow / 2
                dp[row + 1][glass + 1] += flow / 2
            }
        }
    }

    return if (dp[query_row][query_glass] < 1) {
        dp[query_row][query_glass]
    } else {
        (1).toDouble()
    }
}

fun main() {
    println(champagneTower(4, 1, 0))
    println(champagneTower(25, 6, 1))
}
