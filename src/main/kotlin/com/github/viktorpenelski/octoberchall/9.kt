package com.github.viktorpenelski.octoberchall

import java.util.*

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

const val separator = ","
const val nullNode = "n"

// Encodes a URL to a shortened URL.
fun serialize(root: TreeNode?): String {
    if (root == null) return ""

    val sj = StringJoiner(separator)
    val q: Queue<TreeNode?> = LinkedList()
    q.offer(root)

    while (q.isNotEmpty()) {
        val node = q.poll()
        if (node == null) {
            sj.add(nullNode)
        } else {
            sj.add(node.`val`.toString())
            q.offer(node.left)
            q.offer(node.right)
        }
    }

    return sj.toString()


}

// Decodes your encoded data to tree.
fun deserialize(data: String): TreeNode? {
    if (data.isEmpty() || data[0] == nullNode[0]) return null

    val split = data.split(separator)

    val q: Queue<TreeNode> = LinkedList()
    val root = TreeNode(split[0].toInt())
    q.offer(root)

    var i = 1
    while (i < split.size) {
        val node = q.poll()
        if (split[i] != nullNode) {
            val left = TreeNode(split[i].toInt())
            node.left = left
            q.offer(left)
        }
        i++
        if (split[i] != nullNode) {
            val right = TreeNode(split[i].toInt())
            node.right = right
            q.offer(right)
        }
        i++
    }

    return root

}

fun main() {

    val root = TreeNode(2)
    val left = TreeNode(1)
    val right = TreeNode(3)
    val l2Right = TreeNode(5)

    root.left = left
    root.right = right
    right.right = l2Right

    val serialized = serialize(root)
    println(serialized)
    val deserializedRoot = deserialize(serialized)
    println(deserializedRoot)
    print(serialize(deserializedRoot))
}