import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());

            if(data == 0) {
                int rtn = que.isEmpty() ? 0 : que.poll();
                sb.append(rtn + "\n");
                continue;
            }

            que.add(data);
        }
        System.out.println(sb);
    }
}