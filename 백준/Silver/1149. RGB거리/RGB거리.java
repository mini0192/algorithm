import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] rtn = new int[3][N + 1];

        for(int i = 1; i <= N; i++) {
            int[] data = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            rtn[0][i] = Math.min(rtn[1][i - 1], rtn[2][i - 1]) + data[0];
            rtn[1][i] = Math.min(rtn[0][i - 1], rtn[2][i - 1]) + data[1];
            rtn[2][i] = Math.min(rtn[0][i - 1], rtn[1][i - 1]) + data[2];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(rtn[i][N], min);
        }
        System.out.println(min);
    }
}