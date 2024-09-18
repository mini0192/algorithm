import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];

        String[] data = br.readLine().split(" ");
        for(int i = 1; i <= data.length; i++) {
            A[i] = Integer.parseInt(data[i - 1]);
        }
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j] && dp[i] < (dp[j] + 1)) dp[i] = dp[j] + 1;
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}