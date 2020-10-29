package com.github.viktorpenelski.octoberchall

fun bagOfTokensScore(tokens: IntArray, P: Int): Int {



    var power = P
    var score = 0

    var head = 0
    var tail = tokens.lastIndex

    tokens.sort()

    while (head <= tail) {
        if (power >= tokens[head]) {
            power -= tokens[head]
            score++
            head++
        } else if (score > 0 && head != tail) {
            power += tokens[tail]
            tail--
            score--
        } else {
            return score
        }
    }

    return score
}


fun main() {
    println(bagOfTokensScore(intArrayOf(100), 50))
    println(bagOfTokensScore(intArrayOf(100, 200), 150))
    println(bagOfTokensScore(intArrayOf(100,200,300,400), 200))
    println(bagOfTokensScore(intArrayOf(26), 51))
    println(bagOfTokensScore(intArrayOf(81,91,31), 73))

}