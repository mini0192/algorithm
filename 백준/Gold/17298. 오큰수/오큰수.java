import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];
        int[] rtn = new int[N];

        String[] lineStr = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(lineStr[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && line[i] > line[stack.peek()]) {
                rtn[stack.pop()] = line[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            rtn[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++) {
            bw.write(rtn[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}