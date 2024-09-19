import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] data = new int[N][N];

        for(int i = 0; i < N; i++) {
            data[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int index = 1; index < N; index++) {
            for(int i = 0; i < index + 1; i++) {
                if(i - 1 < 0) data[index][i] += data[index - 1][i];
                else if(i == index) data[index][i] += data[index - 1][i - 1];
                else data[index][i] += Math.max(data[index - 1][i - 1], data[index - 1][i]);
            }
        }

        System.out.println(Arrays.stream(data[N - 1]).max().getAsInt());
    }
}