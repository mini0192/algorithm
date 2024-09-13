import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queA = new PriorityQueue<>();
        PriorityQueue<Integer> queB = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());

            if(data == 0) {
                int a = queA.isEmpty() ? Integer.MAX_VALUE : queA.peek();
                int b = queB.isEmpty() ? Integer.MAX_VALUE : queB.peek() * -1;

                if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE) buffer.append(0 + "\n");
                else if(b > a) buffer.append(queA.poll() + "\n");
                else buffer.append(queB.poll() + "\n");
            }
            else if(data < 0)queB.add(data);
            else queA.add(data);
        }

        System.out.println(buffer.toString());
    }
}