import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    private static long[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        Deque<String> dq = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");

            if(data[0].equals("push")) {
                dq.addLast(data[1]);
                continue;
            }

            else if(data[0].equals("front")) {
                if (dq.isEmpty()) sb.append("-1");
                else sb.append(dq.peekFirst());
            }

            else if(data[0].equals("back")) {
                if (dq.isEmpty()) sb.append("-1");
                else sb.append(dq.peekLast());
            }

            else if(data[0].equals("pop")) {
                if (dq.isEmpty()) sb.append("-1");
                else sb.append(dq.pollFirst());
            }

            else if(data[0].equals("size")) {
                sb.append(dq.size());
            }

            else if(data[0].equals("empty")) {
                sb.append(dq.isEmpty() ? 1 : 0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}