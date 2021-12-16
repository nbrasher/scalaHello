package scalaHello

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers._

class DoubleLinkedList extends AnyFunSpec {
    val dll = new DoublyLinkedList()
    describe("DLL behavior") {
        it("has a head and tail") {
            assert( dll.head.next == Some(dll.tail) )
            assert( dll.tail.prev == Some(dll.head) )
        }
        it("adds in order and removes correctly") {
            val a = new Node(4, 1, None, None)
            val b = new Node(5, 2, None, None)
            dll.insert(a)
            dll.insert(b)
            assert( dll.head.next == Some(b) )
            assert( dll.tail.prev == Some(a) )

            dll.remove(a)
            assert( dll.head.next == Some(b) )
            assert( dll.tail.prev == Some(b) )
        }
    }
}

class LRUCacheSpec extends AnyFunSpec {
    describe("LRU Cache behavior") {
        it("add values to cache") {
            val lruc = new LRUCache(5)
            lruc.add(1, 2)
            lruc.add(3, 4)
            assert( lruc.get(1) == Some(2) )
            assert( lruc.get(3) == Some(4) )
            assert( lruc.get(2) == None )
        }
        it("evict old values from cache") {
            val lruc = new LRUCache(2)
            lruc.add(1, 2)
            lruc.add(2, 3)
            assert( lruc.get(1) == Some(2) )
            assert( lruc.get(2) == Some(3) )

            lruc.get(1)
            lruc.add(2, 5)
            assert( lruc.get(3) == None )
            assert( lruc.get(1) == Some(2) )
            assert( lruc.get(2) == Some(5) )

            lruc.add(6, 7)
            assert( lruc.get(1) == None )
            assert( lruc.get(6) == Some(7) )
            assert( lruc.get(2) == Some(5) )
        }
    }
}