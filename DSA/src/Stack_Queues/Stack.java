package Stack_Queues;

public class Stack {
    private Node top;
    private int length;

    Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        length = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }


    public int getLength() {
        return length;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        length++;
    }


    public int pop() {
        if (length == 0) {
            System.out.println("Stack is empty");
            return -1;
        }

        Node temp = top;
        top = top.next;
        temp.next = null;
        length--;

        return temp.value;
    }
}