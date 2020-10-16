package com.github.viktorpenelski.octoberchall

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    if (matrix.isEmpty()) return false

    val rows = matrix.size
    val cols = matrix[0].size

    var row = 0
    var col = cols - 1
    while(col >= 0 && row <= rows - 1) {
        val current = matrix[row][col]
        if (current == target) return true

        if (current > target) {
            col -= 1
        } else {
            row += 1
        }
    }

    return false
}