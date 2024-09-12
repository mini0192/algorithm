import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int L = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0, Integer.parseInt(line2[0])});

        bw.write(Integer.parseInt(line2[0]) + " ");

        for(int i = 1; i < N; i++) {
            int data = Integer.parseInt(line2[i]);
            int first = dq.peekFirst()[0];
            if(i - first >= L) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && dq.peekLast()[1] > data) {
                dq.removeLast();
            }

            dq.addLast(new int[]{i, data});
            bw.write(dq.peekFirst()[1] + " ");
        }
        bw.flush();
        bw.close();
    }
}