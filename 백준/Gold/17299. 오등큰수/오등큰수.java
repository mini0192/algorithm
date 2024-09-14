import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] max = new int[1000001];
        int[] rtn = new int[N];

        for(int l : line) {
            max[l]++;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty()) {
                int a = max[line[stack.peek()]];
                int b = max[line[i]];
                if(a < b) rtn[stack.pop()] = line[i];
                else break;
            }

            stack.push(i);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++) {
            int data = (rtn[i] == 0) ? rtn[i] = -1 : rtn[i];
            sb.append(data + " ");
        }
        System.out.println(sb.toString());
    }
}