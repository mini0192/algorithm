import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}