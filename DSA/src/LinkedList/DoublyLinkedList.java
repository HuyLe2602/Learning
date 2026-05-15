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

        //Code mới ngày 14/5
        public Node removeLast() {
            if (length == 0) return null;
            Node temp = tail;
            if (length == 1) {
                head = null;
                tail = null;
            }else
            {
                tail = tail.prev; //tail sẽ là node trước đó
                tail.next = null; //tail.next sẽ là null
                temp.prev = null; //temp.prev sẽ là null

            }
            length--;
            return temp;
        }
        //Code mới ngày 15/5
        public void prepend(int value) {
            Node newNode = new Node(value);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head; //newNode.next sẽ là head
                head.prev = newNode; //head.prev sẽ là newNode
                head = newNode; //head sẽ là node mới
            }
            length++;   // tăng độ dài của danh sách lên 1
        }

         public Node removeFirst() {
            if (length == 0) return null;
            Node temp = head;
            if (length == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next; //head sẽ là node tiếp theo
                head.prev = null; //head.prev sẽ là null
                temp.next = null; //temp.next sẽ là null
            }
            length--;   // giảm độ dài của danh sách xuống 1
            return temp;
        }

        public Node get(int index) {
            if (index < 0 || index >= length) return null;
            Node temp = head;
            if (index < length / 2) {
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }       // nếu node nằm ở nữa đầu danh sach thì ta sẽ duyệt từ head đến node đó
            } else {
                temp = tail;
                for (int i = length - 1; i > index; i--) {
                    temp = temp.prev;
                }
            }     // nếu node nằm ở nữa cuối danh sach thì ta sẽ duyệt từ tail đến node đó
            return temp;
        }

        public boolean set(int index, int value) {
            Node temp = get(index);
            if (temp != null) {
                temp.value = value;
                return true;
            }
            return false;
        }

         public boolean insert(int index, int value) {
            if (index < 0 || index > length) return false;
            if (index == 0) {
                prepend(value);
                return true;
            }
            if (index == length) {
                append(value);
                return true;
            }
            Node newNode = new Node(value);
            Node before = get(index - 1);
            Node after = before.next;

            before.next = newNode; //before.next sẽ là newNode
            newNode.prev = before; //newNode.prev sẽ là before
            newNode.next = after; //newNode.next sẽ là after
            after.prev = newNode; //after.prev sẽ là newNode
            length++;
            return true;
        }

         public Node remove(int index) {
             if (index < 0 || index >= length) return null;
             if (index == 0) return removeFirst();
             if (index == length - 1) return removeLast();

             Node temp = get(index);

             temp.prev.next = temp.next; //temp.prev.next sẽ là temp.next
             temp.next.prev = temp.prev; //temp.next.prev sẽ là temp.prev
             temp.next = null; //temp.next sẽ là null
             temp.prev = null; //temp.prev sẽ là null
             length--;
             return temp;
         }


}
