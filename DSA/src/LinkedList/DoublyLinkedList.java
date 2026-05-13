package LinkedList;

public class DoublyLinkedList {
        private Node head;
        private Node tail;
        private int length;

        class Node{
            int value;
            Node next;

            Node prev;  //trỏ ngược

            Node(int value) {
                this.value = value;
            }
        }
        DoublyLinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void getHead() {
                System.out.println("Head: " + head.value);
        }

        public void getTail() {
                System.out.println("Tail: " + tail.value);
        }

        public void getLength() {
                System.out.println("Length: " + length);
        }

        // code moi ngay 13/5

        public void append(int value) {
            Node newNode = new Node(value);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail; //trỏ ngược
                tail = newNode; //tail sẽ là node mới
            }
            length++;
        }
}
