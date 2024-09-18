import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cache = new long[N];
        cache[0] = 1;
        if(N > 1) cache[1] = 2;

        for(int i = 2; i < N; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % 15746;
        }

        System.out.println(cache[N - 1]);
    }
}