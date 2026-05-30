package Heap;

public class Main {
    static void main() {
        Heap myheap = new Heap(11);
        myheap.insert(1);
        myheap.insert(2);
        myheap.insert(3);
        myheap.insert(4);
        myheap.insert(5);
        myheap.insert(6);
        myheap.insert(7);
        myheap.insert(8);
        myheap.insert(9);

        System.out.println(myheap.getHeap());

        myheap.insert(10);

        System.out.println(myheap.getHeap());
    }
}
