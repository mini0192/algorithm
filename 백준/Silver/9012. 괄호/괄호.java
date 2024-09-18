import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            Stack<Boolean> stack = new Stack<>();

            boolean isGood = true;
            for(String s : line) {
                if(s.equals("(")) stack.push(true);
                else if(s.equals(")")) {
                    if(stack.isEmpty()) {
                        isGood = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) isGood = false;
            if(isGood) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}