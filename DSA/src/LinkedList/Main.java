package LinkedList;
public class Main {
    public static void main(String[] args)
    {
        LinkedList mylinkedList = new LinkedList(10);
        /*mylinkedList.printAll();
        mylinkedList.printList();

        mylinkedList.append(2);


        //return 2 node
        System.out.println(mylinkedList.removeLast().value);
        //return 1 node
        System.out.println(mylinkedList.removeLast().value);
        //return null
        System.out.println(mylinkedList.removeLast());*/


        //Main cua 6/5
//        mylinkedList.append(1);
//        mylinkedList.append(2);
//        mylinkedList.append(3);
//
//        System.out.println(mylinkedList.get(2).value+ "\n");
//
//        mylinkedList.printList();

/*        mylinkedList.append(3);
        mylinkedList.append(23);
        mylinkedList.append(7);

        System.out.println(mylinkedList.set(2,5));

        mylinkedList.printList();*/

//        mylinkedList.append(3);
//
//        mylinkedList.insert(1, 1);
//
//        mylinkedList.printList();

        mylinkedList.append(1);
        mylinkedList.append(2);
        mylinkedList.append(3);
        mylinkedList.append(4);
        mylinkedList.append(5);
        mylinkedList.append(6);
        mylinkedList.append(7);
        mylinkedList.append(8);
        mylinkedList.append(9);

/*        System.out.println(mylinkedList.remove(2));

        mylinkedList.printList();*/

        mylinkedList.reverseBetween(7,2);
        System.out.println("Reverse between 2 and 7: ");
        mylinkedList.printList();
    }
}

