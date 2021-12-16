package scalaHello

import com.typesafe.scalalogging.LazyLogging

class Node (
    val key: Int,
    val value: Int,
    var next: Option[Node],
    var prev: Option[Node]
)

class DoublyLinkedList {
    val head = new Node(-1, -1, next=None, prev=None)
    val tail = new Node(-1, -1, next=None, prev=Some(head))
    head.next = Some(tail)

    def insert(node: Node): Unit = {
        node.next = head.next
        node.prev = Option(head)
        head.next match { case Some(n) => n.prev = Option(node)}
        head.next = Option(node)
    }
    def remove(node: Node): Unit = {
        node.prev match { case Some(n) => n.next = node.next}
        node.next match { case Some(n) => n.prev = node.prev}
        node.next = None
        node.prev = None
    }
}

class LRUCache(val capacity: Int) extends LazyLogging {
    var len = 0
    val queue = new DoublyLinkedList()
    val cache = collection.mutable.Map[Int, Node]()

    def add(key: Int, value: Int) = {
        if (len == capacity) {
            val toRemove = queue.tail.prev.get
            queue.remove(toRemove)
            cache.remove(toRemove.key)
            len -= 1
        }

        val node = new Node(key, value, null, null)
        cache(key) = node
        queue.insert(node)
        len += 1
    }

    def get(key: Int): Option[Int] = {
        cache.get(key) match {
            case Some(node) => {
                queue.remove(node)
                queue.insert(node)
                return Some(node.value)
            }
            case None => return None
        }
    }
}