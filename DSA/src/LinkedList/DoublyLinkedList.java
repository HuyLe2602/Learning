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

         //code moi ngay 19/5
        public boolean isPalindrome() {
            if (length == 0) return false;
            Node left = head;
            Node right = tail;
            while (left != right && left.prev != right)  //duyệt từ 2 đầu vào
            {
                if (left.value != right.value) //giá trị khác nhau thì không phải là palindrome
                {
                    return false;
                }
                left = left.next; // di chuyển trái sang phải
                right = right.prev; // di chuyển phải sang trái
            }
            return true;
        }

        public void reverse(){
            if (length == 0|| length ==1){
                return;
            }
            Node current = head;
            Node temp = null;{

                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current=current.prev;

            }

            temp = tail;
            tail = head;
            head = temp;

        }

    public void partitionList(int x) {

        if (head == null) {
            return;
        }

        Node lessHead = null;
        Node lessTail = null;

        Node greaterHead = null;
        Node greaterTail = null;

        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = null;
            current.prev = null;

            if (current.value < x) {

                if (lessHead == null) {
                    lessHead = current;
                    lessTail = current;
                } else {
                    lessTail.next = current;
                    current.prev = lessTail;
                    lessTail = current;
                }

            } else {

                if (greaterHead == null) {
                    greaterHead = current;
                    greaterTail = current;
                } else {
                    greaterTail.next = current;
                    current.prev = greaterTail;
                    greaterTail = current;
                }
            }

            current = next;
        }

        if (lessHead == null) {
            head = greaterHead;
            tail = greaterTail;
            return;
        }

        lessTail.next = greaterHead;

        if (greaterHead != null) {
            greaterHead.prev = lessTail;
        }

        head = lessHead;

        if (greaterTail != null) {
            tail = greaterTail;
        } else {
            tail = lessTail;
        }
    }
    public void reverseBetween(int startIndex, int endIndex) {

        if (head == null) {
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;

        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        Node current = prev.next;

        for (int i = 0; i < endIndex - startIndex; i++) {

            Node temp = current.next;

            current.next = temp.next;

            if (temp.next != null) {
                temp.next.prev = current;
            }

            temp.next = prev.next;
            prev.next.prev = temp;

            prev.next = temp;
            temp.prev = prev;
        }

        head = dummy.next;
        head.prev = null;
    }



    public void swapPairs(){
        if(length <= 1){
            return;
        }
        Node currentNode = head;
        Node nextNode = currentNode.next;
        head = nextNode;
        while(currentNode != null && currentNode.next != null){
            // Get next node and previous node
            nextNode = currentNode.next;
            Node previousNode = currentNode.prev;

            // start to swap data
            if(previousNode != null){
                previousNode.next = nextNode;
            }
            currentNode.prev = nextNode;
            currentNode.next = nextNode.next;
            if(nextNode.next != null){
                nextNode.next.prev = currentNode;
            }
            nextNode.next = currentNode;
            nextNode.prev = previousNode;

            // move the pointer to the next one
            currentNode = currentNode.next;
        }
    }





}
