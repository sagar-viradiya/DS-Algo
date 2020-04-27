package leetcode

/*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
    it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:

    LRUCache cache = new LRUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4

 */
fun main() {
    val lruCache = LRUCache(2)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    println(lruCache.get(1))
    lruCache.put(3, 3)
    println(lruCache.get(2))
    lruCache.put(4, 4)
    println(lruCache.get(1))
    println(lruCache.get(3))
    println(lruCache.get(4))
}

class LRUCache(capacity: Int) {

    val size = capacity
    private val hashMapOfValue = mutableMapOf<Int, DoublyLinkList.Node<Pair<Int, Int>>>()
    private val cache = DoublyLinkList<Pair<Int, Int>>()

    fun get(key: Int): Int {
        if (hashMapOfValue.containsKey(key)) {
            cache.remove(hashMapOfValue[key]!!)
            cache.addHead(hashMapOfValue[key]!!)
            return hashMapOfValue[key]!!.value.second
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (hashMapOfValue.containsKey(key)) {
            cache.remove(hashMapOfValue[key]!!)
            hashMapOfValue.remove(key)
        } else if (hashMapOfValue.size == size) {
            hashMapOfValue.remove(cache.tail!!.value.first)
            cache.remove(cache.tail!!)
        }
        val node = DoublyLinkList.Node(Pair(key, value))
        cache.addHead(node)
        hashMapOfValue[key] = node
    }
}

class DoublyLinkList<T> {

    class Node<T>(val value: T, var previous: Node<T>? = null, var next: Node<T>? = null)

    var head: Node<T>? = null
    var tail: Node<T>? = null

    fun addHead(node: Node<T>) {
        if (head == null) {
            head = node
            tail = node
            return
        }
        head!!.previous = node
        node.next = head
        head = node
    }

    fun remove(node: Node<T>) {
        node.previous?.next = node.next
        node.next?.previous = node.previous

        if (node == head) {
            head = node.next
        }

        if (node == tail) {
            tail = node.previous
        }
        node.next = null
        node.previous = null
    }
}