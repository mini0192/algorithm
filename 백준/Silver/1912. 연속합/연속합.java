import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = Integer.parseInt(str[0]);
        for(int count = 1; count < N; count++) {
            dp[count] = Math.max(Integer.parseInt(str[count]), dp[count - 1] + Integer.parseInt(str[count]));
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}