import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if(N == 1) {
            System.out.println(0);
            return;
        }
        
        if(N < 4) {
            System.out.println(1);
            return;
        }

        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= N; i++) {
            int[] c = new int[3];
            c[0] = dp[i - 1];
            c[1] = i % 2 == 0 ? dp[i / 2] : Integer.MAX_VALUE;
            c[2] = i % 3 == 0 ? dp[i / 3] : Integer.MAX_VALUE;

            dp[i] = Arrays.stream(c).min().getAsInt() + 1;
        }

        System.out.println(dp[N]);
    }
}