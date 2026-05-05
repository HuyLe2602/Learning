package LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList mylinkedList = new LinkedList(10);
        mylinkedList.printAll();
        mylinkedList.printList();

        mylinkedList.append(2);


        //return 2 node
        System.out.println(mylinkedList.removeLast().value);
        //return 1 node
        System.out.println(mylinkedList.removeLast().value);
        //return null
        System.out.println(mylinkedList.removeLast());


    }
}
