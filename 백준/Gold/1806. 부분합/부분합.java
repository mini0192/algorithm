import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int S = scan.nextInt();

        int[] numbers = new int[N];

        numbers[0] = scan.nextInt();
        for(int i = 1; i < N; i++) {
            numbers[i] = numbers[i - 1] + scan.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while(end < numbers.length) {
            int startNum = (start == 0) ? 0 : numbers[start];
            int endNum = numbers[end];
            int total = endNum - startNum;

            if(total >= S) {
                if(min > end - start) min = start == 0 ? end + 1 : end - start;
                start++;
                continue;
            }
            end++;
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else if(min == 0) System.out.println(1);
        else System.out.println(min);
    }
}