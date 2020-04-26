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
    val cache = LinkedHashMap<Int, Int>()

    fun get(key: Int): Int {
        if (cache[key] != null) {
            val value = cache[key]
            cache.remove(key)
            cache[key] = value!!
            return cache[key]!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache[key] != null) {
            cache.remove(key)
        } else if (cache.size == size) {
            val first = cache.iterator().next()
            cache.remove(first.key)
        }
        cache[key] = value
    }
}