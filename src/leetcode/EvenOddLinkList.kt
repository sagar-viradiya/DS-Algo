package leetcode

/*
    Given a singly linked list, group all odd nodes together followed by the even nodes.
    Please note here we are talking about the node number and not the value in the nodes.

    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

    Example 1:

    Input: 1->2->3->4->5->NULL
    Output: 1->3->5->2->4->NULL
    Example 2:

    Input: 2->1->3->5->6->4->7->NULL
    Output: 2->3->6->7->1->5->4->NULL
 */

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3)
        }
    }

    if (head.next != null && head.next!!.next != null) {
        val evenHead = head.next
        var pointer1: ListNode? = head
        var pointer2: ListNode? = head.next!!.next
        var tempPointer: ListNode?
        var counter = 0
        while (pointer2 != null) {
            tempPointer = pointer1!!.next
            pointer1.next = pointer2
            pointer1 = tempPointer
            pointer2 = pointer2.next
            counter++
        }
        if (counter % 2 == 0) {
            pointer1!!.next = evenHead
        } else {
            tempPointer = pointer1!!.next
            pointer1.next = null
            tempPointer!!.next = evenHead
        }
    }

    var tempHead: ListNode? = head

    while (tempHead != null) {
        print(tempHead.`val`)
        tempHead = tempHead.next
    }
}