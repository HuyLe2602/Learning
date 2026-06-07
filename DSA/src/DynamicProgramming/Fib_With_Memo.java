package DynamicProgramming;

public class Fib_With_Memo {
    static Integer[] memo= new Integer[100];
    static int counter = 0;

    public static int fib(int n) {
        counter++;
        if (memo[n] <= 1) {
            return memo[n];
        }
        if (n== 0|| n==1) {
            return n;
        }
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    static void main() {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
        System.out.println("Number of calls: " + counter);
    }
}
