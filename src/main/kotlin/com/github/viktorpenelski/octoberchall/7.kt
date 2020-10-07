package com.github.viktorpenelski.octoberchall

import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    val deq = ArrayDeque<ListNode>()
    var node: ListNode? = head
    while (node != null) {
        deq.addLast(node)
        node = node.next
    }

    val rotations = if (k < deq.size) k else (k % deq.size)

    repeat(rotations) {
        val last = deq.pollLast()
        last.next = deq.first
        deq.last.next = null
        deq.addFirst(last)
    }

    return deq.first
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}