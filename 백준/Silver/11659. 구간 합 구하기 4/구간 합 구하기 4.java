import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        int[] numbers = new int[N];
        numbers[0] = scan.nextInt();
        for(int i = 1; i < N; i++) {
            int get = scan.nextInt();
            numbers[i] = numbers[i - 1] + get;
        }

        for(int i = 0; i < M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            if(start == 1) System.out.println(numbers[end - 1]);
            else System.out.println(numbers[end - 1] - numbers[start - 2]);
        }
    }
}