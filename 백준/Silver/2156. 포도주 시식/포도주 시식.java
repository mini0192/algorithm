import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.println(list[0]);
            return;
        }

        if(N == 2) {
            System.out.println(list[0] + list[1]);
            return;
        }

        if(N == 3) {
            int case1 = list[0] + list[1];
            int case2 = Math.max(list[0], list[1]) + list[2];

            System.out.println(Math.max(case1, case2));
            return;
        }

        int[] dp = new int[N];

        dp[0] = list[0];
        dp[1] = list[0] + list[1];

        int case2 = Math.max(list[0], list[1]) + list[2];
        dp[2] = Math.max(dp[1], case2);

        for(int i = 3; i < N; i++) {
            int data = Math.max(dp[i - 3] + list[i - 1], dp[i - 2]) + list[i];
            dp[i] = Math.max(data, dp[i - 1]);
        }

        System.out.println(dp[N - 1]);
    }
}