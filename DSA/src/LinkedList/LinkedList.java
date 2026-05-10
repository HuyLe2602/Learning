package LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    LinkedList(int value) {
        Node initNode = new Node(value);
        this.head = initNode;
        this.tail = initNode;
        this.length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    //code them hom 5/5
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    Node temp = head;
    Node pre = head;

    public Node removeLast() {
        if (length == 0) return null;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //Code moi ngay 6/5
    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
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

        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;

    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    //code mới ngày 7/5
    public Node findMiddleNode() {
        Node a = head;
        Node b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;

        }
        return a;
    }

    public boolean hasLoop() {
        Node a = head;
        Node b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) return true;
        }
        return false;
    }

    //Lưu ý phải chỉnh lại append để phù hợp với hàm này
    public void removeDuplicates() {
        Set<Integer> set = new LinkedHashSet<>();
        Node current = head;
        while (current != null) {
            set.add(current.value);
            current = current.next;
        }
        makeEmpty();
        for (Integer value : set) {
            append(value);
        }
        length = set.size();
    }
    //Code moi ngay 8/5
    public int binaryToDecimal() {
        int i = 0;
        while (head != null) {
            i = i * 2 + head.value;
            head = head.next;
        }
        return i;
    }

    //Code moi ngay 9/5
    public void partitionList(int x) {
        if (head == null) {
            return;
        }
        Node s1 = new Node(-1);
        Node s2 = new Node(-2);
        Node newHead = s1;
        Node newTail = s2;
        while (head != null) {
            if (head.value < x) {
                s1.next = head;
                s1 = s1.next;
            } else {
                s2.next = head;
                s2 = s2.next;
            }
            head = head.next;
        }
    }
    //Code moi ngay 10/5
    public void reverseBetween(int a, int b) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < a; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < b - a ; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

}