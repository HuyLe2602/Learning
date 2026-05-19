package Stack_Queues;

public class Stack {
    private Node top;
    private int length;

    Stack(int value) {
        Node newNode = new Node(value);
        top = new Node(value);
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
    public  void getLenght() {
        System.out.println("Heigth: " + length);
    }
    public void push(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }

    public void pop() {
        if (length == 0) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        length--;
    }

}
