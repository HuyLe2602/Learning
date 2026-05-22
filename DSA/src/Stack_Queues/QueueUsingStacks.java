package Stack_Queues;

public class QueueUsingStacks {

    private Stack stack1;
    private Stack stack2;

    public QueueUsingStacks(int value) {

        stack1 = new Stack(value);
        stack2 = new Stack(value);

        stack2.pop();
    }

    public void enqueue(int value) {

        while (stack1.getLength() > 0) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (stack2.getLength() > 0) {
            stack1.push(stack2.pop());
        }
    }

    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stack1.pop();
    }



    public boolean isEmpty() {
        return stack1.getLength() == 0;
    }

    public int getLength() {
        return stack1.getLength();
    }

    public void printQueue() {

        System.out.println("Queue:");

        stack1.printStack();
    }
}