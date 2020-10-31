package com.github.viktorpenelski.octoberchall

fun recoverTree(root: TreeNode?): Unit {
    val meta = Nodes()
    inOrder(root, meta)
    val tmp = meta.first?.`val`
    meta.first?.`val` = meta.second?.`val`!!
    meta.second?.`val` = tmp!!
}

fun inOrder(node: TreeNode?, meta: Nodes) {
    if (node == null) return

    inOrder(node.left, meta)

    if (meta.first == null && meta.previous.`val` > node.`val`) {
        meta.first = meta.previous
    }
    if (meta.first != null && meta.previous.`val` >= node.`val`) {
        meta.second = node
    }
    meta.previous = node

    inOrder(node.right, meta)
}

data class Nodes(
    var first: TreeNode? = null,
    var second: TreeNode? = null,
    var previous: TreeNode = TreeNode(Int.MIN_VALUE)
)

fun main() {

    val one = TreeNode(1)
    val left = TreeNode(3)
    val t1right = TreeNode(2)

    one.left = left
    left.right = t1right

    recoverTree(one)
    println(one)
}