package Stack_Queues;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    Queue(int value) {

        Node newNode = new Node(value);

        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {

        Node temp = first;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getFirst() {

        if (first == null) {
            return -1;
        }

        return first.value;
    }

    public int getLast() {

        if (last == null) {
            return -1;
        }

        return last.value;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(int value) {

        Node newNode = new Node(value);

        if (length == 0) {

            first = newNode;
            last = newNode;

        } else {

            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public int dequeue() {

        if (length == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        Node temp = first;

        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }

        length--;

        return temp.value;
    }

    public int peek() {

        if (length == 0) {
            return -1;
        }

        return first.value;
    }
}