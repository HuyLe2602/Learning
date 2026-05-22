package Stack_Queues;

public class Main {

    //code moi ngay 22/5
    public static String reverseString(String str) {

        Stack stack = new Stack((int) str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            stack.push((int) str.charAt(i));
        }

        StringBuilder reversedStr = new StringBuilder();

        while (stack.getLength() > 0) {
            reversedStr.append((char) stack.pop());
        }

        return reversedStr.toString();
    }

    public static boolean isBalancedParentheses(String str) {

        int openCount = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // gặp ngoặc mở
            if (ch == '(') {
                openCount++;
            }

            // gặp ngoặc đóng
            else if (ch == ')') {

                // nếu chưa có ngoặc mở mà đã đóng => sai
                if (openCount == 0) {
                    return false;
                }

                openCount--;
            }
        }

        // nếu còn ngoặc mở chưa đóng => sai
        return openCount == 0;
    }
    public static void sortStack(java.util.Stack<Integer> stack) {

        java.util.Stack<Integer> tempStack = new java.util.Stack<>();

        while (!stack.isEmpty()) {

            int temp = stack.pop();

            // đưa phần tử lớn hơn trở lại stack chính
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        // đưa lại về stack ban đầu
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

        public static void main(String[] args)
        {
            Stack mystack = new Stack(4);
            mystack.printStack();
            mystack.getTop();
            mystack.getLength();

            String myString = "hello";
            String reversedString = reverseString(myString);
            System.out.println(reversedString);

            testAndPrint("()", true);
            testAndPrint("()()", true);
            testAndPrint("(())", true);
            testAndPrint("()()()", true);
            testAndPrint("(()())", true);
            testAndPrint(")()(", false);
            testAndPrint(")(", false);
            testAndPrint("(()", false);
            testAndPrint("))", false);
            testAndPrint("(", false);
            testAndPrint(")", false);


            java.util.Stack<Integer> stack = new java.util.Stack<>();

            stack.push(3);
            stack.push(1);
            stack.push(4);
            stack.push(2);

            System.out.println("Before Sort:");
            System.out.println(stack);

            sortStack(stack);

            System.out.println("After Sort:");
            System.out.println(stack);
        }
    public static void testAndPrint(String testStr, boolean expected) {

        boolean result = isBalancedParentheses(testStr);

        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        System.out.println("--------------");
    }

}
}
