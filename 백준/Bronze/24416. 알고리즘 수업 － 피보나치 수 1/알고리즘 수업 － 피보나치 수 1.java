import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int fibCount = 0;
    private static int fibonacciCount = 0;
    private static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fib(N);

        f = new int[N];
        fibonacci(N);

        System.out.println(fibCount + " " + fibonacciCount);
    }

    private static int fib(int n) {
        if(n == 1 || n == 2) {
            fibCount++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        f[0] = f[1] = 1;
        for(int i = 0; i < n - 2; i++) {
            fibonacciCount++;
            f[i + 2] = f[i + 2 - 1] + f[i + 2 - 2];
        }
        return 0;
    }
}