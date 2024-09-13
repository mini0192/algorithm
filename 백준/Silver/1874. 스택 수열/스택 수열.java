import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuffer bw = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        int N = scan.nextInt();
        int[] numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }

        int index = 1;

        for(int i = 0; i < N; i++) {
            while(numbers[i] >= index) {
                stack.push(index++);
                bw.append("+\n");
            }

            if(numbers[i] == stack.peek()) {
                stack.pop();
                bw.append("-\n");
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println(bw.toString());
    }
}