import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(9);
            return;
        }

        long[][] dp = new long[N][10];

        for(int j = 1; j <= 9; j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) dp[i][j] = dp[i - 1][1] % 1000000000;
                else if(j == 9) dp[i][j] = dp[i - 1][8] % 1000000000;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for(long d : dp[N - 1]) {
            sum += d;
        }
        System.out.println(sum % 1000000000);
    }
}