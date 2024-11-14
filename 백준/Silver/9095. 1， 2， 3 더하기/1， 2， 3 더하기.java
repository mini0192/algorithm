import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        for(int count = 0; count < N; count++) {
            int data = Integer.parseInt(br.readLine());
            sb.append(dp(data) + "\n");
        }
        System.out.println(sb);

    }

    private static int dp(int data) {
        if(data == 0)   return 1;
        if(data < 0)    return 0;

        if(cache.containsKey(data)) return cache.get(data);

        int a = dp(data - 1);
        int b = dp(data - 2);
        int c = dp(data - 3);
        cache.put(data, a + b + c);

        return a + b + c;
    }
}
