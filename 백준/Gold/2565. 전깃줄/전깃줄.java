import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] wire = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            wire[i][0] = Integer.parseInt(line[0]);
            wire[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[N];
        int len = 0;

        for(int i = 0; i < N; i++) {
            int B = wire[i][1];
            int pos = Arrays.binarySearch(dp, 0, len, B);

            if(pos < 0) pos = -(pos + 1);

            dp[pos] = B;
            if(pos == len) len++;
        }

        System.out.println(N - len);
    }
}

