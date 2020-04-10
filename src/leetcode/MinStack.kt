package leetcode

import java.util.*

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

    Example:

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.

 */
fun main() {
    val minStack = MinStack()
    minStack.push(2147483646)
    minStack.push(2147483646)
    minStack.push(2147483647)
    println(minStack.top())
    minStack.pop()
    println(minStack.getMin())
    minStack.pop()
    println(minStack.getMin())
    minStack.pop()
    minStack.push(2147483647)
    println(minStack.top())
    println(minStack.getMin())
    minStack.push(Int.MIN_VALUE)
    println(minStack.top())
    println(minStack.getMin())
    minStack.pop()
    println(minStack.getMin())
}

class MinStack {
    private val stack = Stack<Long>()
    private var minVal = Long.MAX_VALUE

    fun push(x: Int) {
        if (stack.isEmpty()) {
            minVal = x.toLong()
            stack.push(x.toLong())
            return
        }

        if (x < minVal) {
            stack.push((2 * x.toLong()) - minVal)
            minVal = x.toLong()
        } else {
            stack.push(x.toLong())
        }
    }

    fun pop() {
        if (stack.isEmpty()) return
        val top = stack.pop()
        if (top < minVal) {
            minVal = 2 * minVal - top
        }
    }

    fun top(): Int {
        val top = stack.peek()
        return if (top < minVal) minVal.toInt() else top.toInt()
    }

    fun getMin(): Int {
        return minVal.toInt()
    }
}