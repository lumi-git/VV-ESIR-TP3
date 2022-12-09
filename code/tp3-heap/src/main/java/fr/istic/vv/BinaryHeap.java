package fr.istic.vv;


import java.util.Comparator;

class BinaryHeap<T> {
    private final Comparator<T> comparator;
    private T[] heap;
    private int size;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = (T[]) new Object[10];
        this.size = 0;
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        T result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return result;
    }

    public int count() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return heap[0];
    }

    public void push(T element) {
        if (size == heap.length) {
            T[] newHeap = (T[]) new Object[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
        heap[size] = element;
        size++;
        heapifyUp();
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private T getRightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private T getLeftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && comparator.compare(getRightChild(index), getLeftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (comparator.compare(heap[index], heap[smallerChildIndex]) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && comparator.compare(heap[index], heap[getParentIndex(index)]) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        T tmp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = tmp;
    }
}