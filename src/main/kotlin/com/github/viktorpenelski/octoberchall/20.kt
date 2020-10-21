package com.github.viktorpenelski.octoberchall

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

fun cloneGraph(node: Node?): Node? {
    if (node == null) return null

    val visited = mutableMapOf<Int, Node>()
    val first = Node(node.`val`)

    clone(node, visited, first)

    return first
}

private fun clone(originalNode: Node?,
                  visited: MutableMap<Int, Node>,
                  clonedNode: Node) {

    if (originalNode == null || visited.contains(originalNode.`val`)) {
        return
    }

    visited[originalNode.`val`] = clonedNode

    originalNode.neighbors
            .filterNotNull()
            .forEach {
                val newCloned = visited.getOrDefault(it.`val`, Node(it.`val`))
                clonedNode.neighbors.add(newCloned)
                clone(it, visited, newCloned)
            }
}

fun main() {
//    [2,4],[1,3],[2,4],[1,3]

    val first = Node(1)
    val second = Node(2)
    val third = Node(3)
    val fourth = Node(4)

    first.neighbors.add(second)
    first.neighbors.add(fourth)
    second.neighbors.add(first)
    second.neighbors.add(third)
    fourth.neighbors.add(first)
    third.neighbors.add(second)
    fourth.neighbors.add(third)
    third.neighbors.add(fourth)

    val cloned = cloneGraph(first)

    println(cloned)


}