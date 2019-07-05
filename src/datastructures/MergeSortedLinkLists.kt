package datastructures

/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */
fun main(args: Array<String>) {
    val l1 = ListNode(9).apply {
        next = ListNode(11).apply {
            next = ListNode(17)
        }
    }

    val l2 = ListNode(10).apply {
        next = ListNode(12).apply {
            next = ListNode(14)
        }
    }

    var pointer1: ListNode? = l1
    var pointer2: ListNode? = l2
    var result: ListNode? = null
    var root: ListNode? = null

    while (pointer1 != null && pointer2 != null) {

        if (pointer1.`val` < pointer2.`val`) {
            if (result == null) {
                result = ListNode(pointer1.`val`)
                root = result
            } else {
                result.next = ListNode(pointer1.`val`)
                result = result.next
            }
            pointer1 = pointer1.next
        } else {
            if (result == null) {
                result = ListNode(pointer2.`val`)
                root = result
            } else {
                result.next = ListNode(pointer2.`val`)
                result = result.next
            }
            pointer2 = pointer2.next
        }
    }

    when {
        pointer1 != null -> {
            while (pointer1 != null) {
                result!!.next = ListNode(pointer1.`val`)
                result = result.next
                pointer1 = pointer1.next
            }
        }
        pointer2 != null -> {
            while (pointer2 != null) {
                result!!.next = ListNode(pointer2.`val`)
                result = result.next
                pointer2 = pointer2.next
            }
        }
    }

    while (root != null) {
        print("${root.`val`}->")
        root = root.next
    }

}

