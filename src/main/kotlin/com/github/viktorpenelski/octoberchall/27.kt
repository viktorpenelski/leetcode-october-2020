package com.github.viktorpenelski.octoberchall

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) return null
        if (head.next == head) return head

        var fast: ListNode? = head.next

        while (fast?.next != null) {
            var mid = head
            while (mid != fast) {
                if (fast.next == mid || fast.next == fast) return fast.next
                mid = mid!!.next
            }
            fast = fast.next

        }
        return null
}

fun main() {
    var zero = ListNode(0)
    var one = ListNode(1)
    var two = ListNode(2)
    var three = ListNode(3)

    zero.next = one
    one.next = two
    two.next = three
    three.next = zero


    println(detectCycle(zero)?.`val`)
}