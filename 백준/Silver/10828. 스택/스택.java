import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static long[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");

            if(data[0].equals("push")) {
                stack.push(data[1]);
                continue;
            }

            else if(data[0].equals("top")) {
                if (stack.isEmpty()) sb.append("-1");
                else sb.append(stack.peek());
            }

            else if(data[0].equals("pop")) {
                if (stack.isEmpty()) sb.append("-1");
                else sb.append(stack.pop());
            }

            else if(data[0].equals("size")) {
                sb.append(stack.size());
            }

            else if(data[0].equals("empty")) {
                sb.append(stack.empty() ? 1 : 0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}