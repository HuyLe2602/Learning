package Tree;

import java.util.ArrayList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node temp = root;

        while (true) {
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.value);
            printInOrder(node.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean contains(int value) {
        Node temp = root;

        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }

        return false;
    }

    //Code mới ngày 1/6
    private boolean rContains(Node currentNode, int value){
        if(currentNode == null){

            //Nếu node hiện tại là null thì có nghĩa là đã đi hết cây mà không tìm thấy giá trị cần tìm

            //Nếu đã có node rồi thì tiếp tục gọi đệ quy để chèn vào cây con bên phải

            return false;
        }
        if(value == currentNode.value){

            //Nếu giá trị của node hiện tại bằng giá trị cần tìm thì trả về true

            return true;
        }
        if (value < currentNode.value){

            //Nếu giá trị cần tìm nhỏ hơn giá trị của node hiện tại thì gọi đệ quy để tìm kiếm trong cây con bên trái

            return rContains(currentNode.left, value);
        } else {

            //Nếu giá trị cần tìm lớn hơn giá trị của node hiện tại thì gọi đệ quy để tìm kiếm trong cây con bên phải

            return rContains(currentNode.right, value);
        }
    }

    private boolean rContains(int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if(currentNode == null){

            //Nếu chỗ này chưa có node nào thì tạo node mới và trả về node đó

            return new Node(value);
        }
        if(value < currentNode.value){

            //nếu giá trị cần chèn nhỏ hơn giá trị của node hiện tại thì gọi đệ quy để chèn vào cây con bên trái

            //sau đó gán lại con trái của node hiện tại bằng kết quả trả về của hàm rInsert

            currentNode.left = rInsert(currentNode.left, value);
        } else {

            //Nếu chỗ này chưa có node nào thì tạo node mới và trả về node đó

            //Nếu đã có node rồi thì tiếp tục gọi đệ quy để chèn vào cây con bên phải

            currentNode.right = rInsert(currentNode.right, value);
        }

        //Trả về node hiện tại sau khi đã chèn xong vào cây con bên trái hoặc bên phải

        return currentNode;
    }

    public void rInsert(int value){

        //Hàm này sẽ gọi hàm rInsert với node gốc và giá trị cần chèn

        //Sau đó gán lại node gốc bằng kết quả trả về của hàm rInsert

        root = rInsert(root, value);
    }

    private Node deleteNode(Node currentNode, int value){

        if(currentNode == null){

            //Nếu node hiện tại là null thì có nghĩa là đã đi hết cây mà không tìm thấy giá trị cần xóa

            return null;
        }
        if(value < currentNode.value){

            //Nếu giá trị cần xóa nhỏ hơn giá trị của node hiện tại thì gọi đệ quy để xóa trong cây con bên trái

            currentNode.left = deleteNode(currentNode.left, value);
        }
        else if (value > currentNode.value){

            //Nếu giá trị cần xóa lớn hơn giá trị của node hiện tại thì gọi đệ quy để xóa trong cây con bên phải

            currentNode.right =deleteNode(currentNode.right, value);
        }
        else {
            if(currentNode.left == null && currentNode.right ==null)
            //Node lá
            {
                return null;
            }

            else if (currentNode.left == null)

            //Node chỉ có một con bên phải

            {
                return currentNode.right;
            }
            else if (currentNode.right == null)

            // Node chỉ có một con bên trái

            {
                return currentNode.left;
            }
            else {
                // Node có cả con trái và con phải
                int subTreeMin = minValue(currentNode.right);
                currentNode.value =subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);

            }


        }

        return currentNode;
    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }

    public int minValue(Node currentNode){
        while (currentNode.left != null){

            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    //Code mới ngày 2/6

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new java.util.LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0){
            currentNode = queue.remove();
            result.add(currentNode.value);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                result.add(currentNode.value);
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                result.add(currentNode.value);
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

}
