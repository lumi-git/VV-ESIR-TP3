package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {
    @Test
    void testPop() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        heap.push(2);
        heap.push(1);
        heap.push(3);
        assertEquals(3, heap.count());
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(0, heap.count());
        assertNull(heap.pop());
    }

    @Test
    void testPeak() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        heap.push(2);
        heap.push(1);
        heap.push(3);
        assertEquals(3, heap.count());
        assertEquals(1, heap.peek());
        assertEquals(1, heap.peek());
        assertEquals(3, heap.count());
        heap.pop();
        heap.pop();
        heap.pop();
        assertNull(heap.peek());
    }

    @Test
    void testPush() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        heap.push(1);
        heap.push(2);
        heap.push(3);
        assertEquals(3, heap.count());

        heap = new BinaryHeap<>(Integer::compareTo);
        for (int i = 0; i < 100; i++) {
            heap.push(i);
        }
        getaVoid(heap);


    }

    private static void getaVoid(BinaryHeap<Integer> heap) {
        assertEquals(100, heap.count());
    }

    @Test
    void testCount() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        heap.push(2);
        heap.push(1);
        heap.push(3);
        assertEquals(3, heap.count());
    }

    @Test
    void testHeapifyUp() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        int n = 100;
        for (int i = 0; i < n; i++) {
            heap.push(1);
        }
        for (int i = n - 1; i >= 0; i--) {
            heap.push(i);
        }

        assertEquals(2 * n, heap.count());
    }
}