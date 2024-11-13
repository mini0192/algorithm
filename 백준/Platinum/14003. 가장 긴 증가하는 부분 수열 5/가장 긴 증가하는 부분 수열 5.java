import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        int[] index = new int[N];
        int[] path = new int[N];
        Arrays.fill(path, -1);

        int length = 0;
        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(lis, 0, length, arr[i]);
            if (pos < 0) pos = -pos - 1;
            lis[pos] = arr[i];
            index[pos] = i;
            if (pos > 0) path[i] = index[pos - 1];
            if (pos == length) length++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = index[length - 1]; i >= 0; i = path[i]) {
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
