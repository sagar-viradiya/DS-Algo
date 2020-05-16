package leetcode_may_challenge

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

    Note:

        The relative order inside both the even and odd groups should remain as it was in the input.
        The first node is considered odd, the second node even and so on ...

 */
fun main() {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    var p1: ListNode? = head
    var p2 = head.next
    val joint = p2
    while (p2 != null) {
        p1!!.next = p2.next
        p2.next = p1.next?.next
        p1 = p1.next ?: p1
        p2 = p2.next
    }
    p1!!.next = joint

    var next: ListNode? = head
    while (next != null) {
        print("${next!!.`val`} -> ")
        next = next!!.next
    }
    print("NULL")
}