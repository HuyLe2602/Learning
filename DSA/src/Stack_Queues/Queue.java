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

     public void getFirst() {
             System.out.println("First: " + first.value);
     }
     public  void getLenght() {
         System.out.println("Length: " + length);
     }
     public void enqueue(int value){
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

     public void dequeue() {
         if (length == 0) {
             System.out.println("Queue is empty");
             return;
         }
         Node temp = first;
         first = first.next;
         temp.next = null;
         length--;
     }
}
