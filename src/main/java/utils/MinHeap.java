package utils;

import models.Lecture;

import java.util.Arrays;
import java.util.List;

public class MinHeap
{
    private Lecture[] Heap;
    private int index;
    private int size;

    public MinHeap(int size) {
        this.size = size;
        this.index = 0;
        Heap = new Lecture[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    public void createHeap(List<Lecture> lectures){
        lectures.forEach(data -> this.insert(data));
    }

    public void insert(Lecture element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (this.compare(Heap[current],Heap[parent(current)])==-1) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    // removes and returns the minimum element from the heap
    public Lecture remove() {
        // since its a min heap, so root = minimum
        Lecture popped = Heap[0];
        Heap[0] = Heap[--index];
        minHeapify(0);
        return popped;
    }

    // heapify the node at i
    private void minHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            if (this.compare(Heap[i],Heap[leftChild(i)])==1 ||
                    this.compare(Heap[i],Heap[rightChild(i)])==1 ) {
                if (this.compare(Heap[leftChild(i)], Heap[rightChild(i)])==-1) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    // builds the min-heap using the minHeapify
    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    // Function to print the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + Heap[i]);
            if (leftChild(i) < index)
                System.out.print(" Left : " + Heap[leftChild(i)]);
            if (rightChild(i) < index)
                System.out.print(" Right :" + Heap[rightChild(i)]);
            System.out.println();
        }
    }
    // swaps two nodes of the heap
    private void swap(int x, int y) {
        Lecture tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    private int compare(Lecture l1, Lecture l2){
        if(l1.getStartTime().isBefore(l2.getStartTime())){
            return -1;
        }else if(l1.getStartTime().isAfter(l2.getStartTime())){
            return 1;
        }
        return 0;
    }

}