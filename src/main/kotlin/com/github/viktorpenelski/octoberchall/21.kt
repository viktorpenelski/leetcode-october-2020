package com.github.viktorpenelski.octoberchall

import java.util.*
import kotlin.math.abs

fun asteroidCollision(asteroids: IntArray): IntArray {

    if (asteroids.size <= 1) return asteroids

    val answer = mutableListOf<Int>()
    val deq = ArrayDeque<Int>()

    for (a in asteroids) {
        if (a < 0) {
            val broken = moveLeft(deq, a)
            if (!broken) {
                answer.add(a)
            }
        } else {
            deq.addLast(a)
        }
    }

    answer.addAll(deq)
    return answer.toIntArray()
}

private fun moveLeft(rightMovingAsteroids: ArrayDeque<Int>, leftMovingAsteroid: Int): Boolean {
    var broken = false
    while (!rightMovingAsteroids.isEmpty()) {
        val last = rightMovingAsteroids.peekLast()
        val absA = Math.abs(leftMovingAsteroid)
        if (absA == last) {
            rightMovingAsteroids.removeLast()
            broken = true
            break
        }
        if (absA < last) {
            broken = true
            break
        }
        if (absA > last) {
            rightMovingAsteroids.removeLast()
        }
    }
    return broken
}

fun main() {
    asteroidCollision(intArrayOf(-2,-1,1,2)).forEach { print("$it,") }
}