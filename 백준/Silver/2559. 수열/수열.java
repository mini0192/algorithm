import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        int[] data = new int[N];

        data[0] = Integer.parseInt(line[0]);
        for(int i = 1; i < N; i++) {
            data[i] = data[i - 1] + Integer.parseInt(line[i]);
        }

        int max = data[K - 1];
        for(int i = 0; i < N - K; i++) {
            int num = data[i + K] - data[i];
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}