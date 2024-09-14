import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = br.readLine().toCharArray();
        char[] check = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for(char t : target) {
            stack.push(t);
            if(t != check[check.length - 1]) continue;

            Stack<Character> data = new Stack<>();
            for(int i = 0; i < check.length; i++) {
                if(!stack.isEmpty() && check[check.length - i - 1] == stack.peek()) {
                    data.push(stack.pop());
                } else {
                    while(!data.isEmpty()) {
                        stack.push(data.pop());
                    }
                    break;
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}