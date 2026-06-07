package DynamicProgramming;

public class Fib_No_Memo {
    static int counter =0;
    public static int fib(int n) {
        counter++;
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static void main() {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
        System.out.println("Number of calls: " + counter);
    }
}