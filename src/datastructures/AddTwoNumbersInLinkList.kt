package datastructures

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
class ListNode(var `val`: Int) {
         var next: ListNode? = null
}

fun main(args: Array<String>) {
    val l1 = ListNode(9)

    val l2 = ListNode(1)

    var carry = 0
    var result: ListNode? = null
    var root: ListNode? = null

    var pointer1: ListNode? = l1
    var pointer2: ListNode? = l2
    var addition: Int

    while (pointer1 != null && pointer2 != null) {
        addition = pointer1.`val` + pointer2.`val` + carry
        carry = 0
        if (addition < 10) {
            if (result == null) {
                result = ListNode(addition)
                root = result
            } else {
                result.next = ListNode(addition)
                result = result.next
            }
        } else {
            carry = addition/10
            if (result == null) {
                result = ListNode(addition % 10)
                root = result
            } else {
                result.next = ListNode(addition % 10)
                result = result.next
            }
        }
        pointer1 = pointer1.next
        pointer2 = pointer2.next
    }

    when {
        pointer1 != null -> {
            while (pointer1 != null) {
                addition = pointer1.`val` + carry
                carry = 0
                if (addition < 10) {
                    result!!.next = ListNode(addition)
                    result = result.next
                } else {
                    carry = addition/10
                    result!!.next = ListNode(addition % 10)
                    result = result.next
                }
                pointer1 = pointer1.next
            }
            if (carry > 0) {
                result!!.next = ListNode(carry)
            }
        }
        pointer2 != null -> {
            while (pointer2 != null) {
                addition = pointer2.`val` + carry
                carry = 0
                if (addition < 10) {
                    result!!.next = ListNode(addition)
                    result = result.next
                } else {
                    carry = addition/10
                    result!!.next = ListNode(addition % 10)
                    result = result.next
                }
                pointer2 = pointer2.next
            }
            if (carry > 0) {
                result!!.next = ListNode(carry)
            }
        }
        carry > 0 -> result!!.next = ListNode(carry)
    }

    while (root != null) {
        print("${root.`val`}->")
        root = root.next
    }



}