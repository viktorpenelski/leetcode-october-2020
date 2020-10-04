package com.github.viktorpenelski.octoberchall

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val answer = mutableListOf<MutableList<Int>>()
    rec(candidates, target, answer, CombSum())
    return answer
}

fun rec(candidates: IntArray,
        target: Int,
        answer: MutableList<MutableList<Int>>,
        cs: CombSum) {

    if (cs.idx >= candidates.size) {
        return
    }

    if (cs.sum + candidates[cs.idx] == target) {
        val cs2 = cs.copy(elements = cs.elements.toMutableList(), sum = cs.sum, idx = cs.idx + 1)
        cs.elements.add(candidates[cs.idx])
        answer.add(cs.elements)
        rec(candidates, target, answer, cs2)
        return
    }

    if (cs.sum + candidates[cs.idx] > target) {
        cs.idx += 1
        rec(candidates, target, answer, cs)
    } else {
        val cs2 = cs.copy(elements = cs.elements.toMutableList(), sum = cs.sum, idx = cs.idx + 1)
        cs.sum += candidates[cs.idx]
        cs.elements.add(candidates[cs.idx])
        rec(candidates, target, answer, cs)
        rec(candidates, target, answer, cs2)
    }

}

data class CombSum(
        val elements: MutableList<Int> = mutableListOf(),
        var sum: Int = 0,
        var idx: Int = 0
)

fun main() {
    combinationSum(intArrayOf(4,2,8), 8).forEach {
        it.forEach { el -> print("$el, ") }
        println()
    }
}