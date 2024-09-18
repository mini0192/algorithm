import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Integer> cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        cache = new HashMap<>();

        while(true) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a == b && b == c && a == -1) break;

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, f(a, b, c)));
        }
        System.out.println(sb);
    }

    private static int f(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) {
            return getCache(20, 20, 20);
        }
        if(a < b && b < c) {
            int rtn1 = getCache(a, b, c - 1);
            int rtn2 = getCache(a, b - 1, c - 1);
            int rtn3 = getCache(a, b - 1, c);

            return rtn1 + rtn2 - rtn3;
        }
        int rtn1 = getCache(a - 1, b, c);
        int rtn2 = getCache(a - 1, b - 1, c);
        int rtn3 = getCache(a - 1, b, c - 1);
        int rtn4 = getCache(a - 1, b - 1, c - 1);
        return rtn1 + rtn2 + rtn3 - rtn4;
    }

    private static int getCache(int a, int b, int c) {
        String cacheStr = String.format("%d.%d.%d", a, b, c);
        if(cache.containsKey(cacheStr)) return cache.get(cacheStr);

        int rtn = f(a, b, c);
        cache.put(cacheStr, rtn);
        return rtn;
    }
}