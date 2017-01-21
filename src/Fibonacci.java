
public class Fibonacci {
    public static void main(String[] args) {

        fib(5);
    }

    public static int fib(int k) {
        int n1 = 1, n2 = 1, n = 0;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 0; i < k; i++) {
            n = n1 + n2;
            System.out.print(n + " ");
            n1 = n2;
            n2 = n;
        }
        System.out.println();
        return n;
    }
}


