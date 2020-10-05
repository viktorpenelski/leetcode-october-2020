package com.github.viktorpenelski.octoberchall

import kotlin.math.pow


// 1010
// 1111
//       0+8+0+2+0 => 10
// max: 16+8+4+2+1 => 15
// 10000
//
// int 5


fun bitwiseComplement(N: Int): Int {
    if (N == 0) return 1

    val max = (Integer.highestOneBit(N) shl 1) - 1
    return max - N
}

private fun doubleSolution(N: Int): Int {
    var num = N
    var count = 0
    while (num > 0) {
        count++
        num /= 2
    }

    val max = 2.toDouble().pow(count.toDouble()) - 1

    return max.toInt() - N
}

private fun stringSolution(N: Int): Int {
    val binaryChars = N.toString(2).toCharArray()
    binaryChars.forEachIndexed { idx, c ->
        if (c == '0') {
            binaryChars[idx] = '1'
        } else {
            binaryChars[idx] = '0'
        }
    }

    return binaryChars.joinToString("").toInt(2)
}

// 1111
fun main() {
    println(bitwiseComplement(5))
}