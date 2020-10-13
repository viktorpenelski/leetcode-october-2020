package com.github.viktorpenelski.octoberchall

fun sortList(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head
    val mid = middleNode(head)
    val left = sortList(head)
    val right = sortList(mid)
    return mergeTwoLists(left, right)
}

fun middleNode(head: ListNode?): ListNode? {
    if (head == null) return null

    var slow = head
    var fast = head
    val mid: ListNode?
    while (fast?.next != null && fast.next?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }
    mid = slow?.next
    slow?.next = null
    return mid
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var left = l1
    var right = l2
    val dummyHead = ListNode(-1)
    var current: ListNode? = dummyHead
    while (left != null && right != null) {
        if (left.`val` <= right.`val`) {
            current!!.next = left
            left = left.next
        } else {
            current!!.next = right
            right = right.next
        }
        current = current.next
    }
    current!!.next = left ?: right
    return dummyHead.next
}

fun main() {

    val head = ListNode(99)
    val _1 = ListNode(1)
    val _2 = ListNode(58)
    val _3 = ListNode(69)
    val _4 = ListNode(99)
    val _5 = ListNode(7)
    val _6 = ListNode(3)
    val _7 = ListNode(12)

    head.next = _1
    _1.next = _2
    _2.next = _3
    _3.next = _4
    _4.next = _5
    _5.next = _6
    _6.next = _7

    val sorted = sortList(head)

    var node: ListNode? = sorted
    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}