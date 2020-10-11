package com.github.viktorpenelski.octoberchall

fun removeDuplicateLetters(s: String): String {

    val lastIndexes: MutableMap<Char, Int> = getLastIndexesFor(s)

    val sb = StringBuilder()

    var start = 0
    repeat(lastIndexes.size) {
        val end = findLeastIdx(lastIndexes)

        var smallestChar = 'z' + 1
        for (i in start..end) {
            if (s[i] < smallestChar && lastIndexes.containsKey(s[i])) {
                smallestChar = s[i]
                start = i + 1
            }
        }
        sb.append(smallestChar)
        lastIndexes.remove(smallestChar)
    }

    return sb.toString()
}

fun findLeastIdx(lastIndex: MutableMap<Char, Int>): Int {
    return lastIndex.map { it.value }.min() ?: -1
}

fun getLastIndexesFor(s: String): MutableMap<Char, Int> {
    val map = mutableMapOf<Char, Int>()
    s.forEachIndexed{ i, c ->
        map[c] = i
    }
    return map
}

fun main() {
    println(('6' + 100 < 'z'))
}