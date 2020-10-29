package com.github.viktorpenelski.octoberchall

fun winnerSquareGame(n: Int): Boolean {
    if (n == 0) return false

    val dp = BooleanArray(n+1)
    for (i in 1..n) {
        var j = 1
        while (j*j <= i) {
            if (dp[i-(j*j)] == false) {
                dp[i] = true
                break
            }
            j++
        }
    }
    return dp[n]

}