import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];

        for(int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];

        if(N < 3) {
            int sum = 0;
            for(int d : data) {
                sum += d;
            }
            System.out.println(sum);
            return;
        }
        dp[0] = data[0];
        dp[1] = data[0] + data[1];
        dp[2] = Math.max(data[0], data[1]) + data[2];

        for(int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + data[i - 1]) + data[i];
        }

        System.out.println(dp[N - 1]);
    }
}