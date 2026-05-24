package HashTables;

public class HashTable {
    private int size;
    private Node[] dataMap;
    public class Node {
        private String key;
        private String value;
        private Node next;

        public Node(String key,int value){
            this.key=key;
            this.value = value;
        }
    }

    public HashTable() {

        dataMap = new Node[size];
    }
    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {

            System.out.println(i+":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" {" +temp.key+ "="+temp.value+"}");
                temp = temp.next;
            }
        }
    }

    //xác định nơi lưu dữ liệu trong HashTable
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = (int) keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

}
