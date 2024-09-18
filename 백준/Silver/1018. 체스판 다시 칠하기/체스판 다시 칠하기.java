import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] dA = new int[N + 1][M + 1];
        int[][] dB = new int[N + 1][M + 1];

        boolean check = false;
        for(int i = 1; i <= N; i++) {
            if(M % 2 == 0) check = !check;

            char[] data = br.readLine().toCharArray();
            for(int x = 0; x < M; x++) {
                int j = x + 1;
                if(data[x] == 'W') {
                    dA[i][j] = check ? 1 : 0;
                    dB[i][j] = check ? 0 : 1;
                } else {
                    dA[i][j] = check ? 0 : 1;
                    dB[i][j] = check ? 1 : 0;
                }

                check = !check;

                dA[i][j] = dA[i - 1][j] + dA[i][j - 1] + dA[i][j] - dA[i - 1][j - 1];
                dB[i][j] = dB[i - 1][j] + dB[i][j - 1] + dB[i][j] - dB[i - 1][j - 1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 8; i <= N; i++) {
            for (int j = 8; j <= M; j++) {
                int a = dA[i][j] - dA[i - 8][j] - dA[i][j - 8] + dA[i - 8][j - 8];
                int b = dB[i][j] - dB[i - 8][j] - dB[i][j - 8] + dB[i - 8][j - 8];

                min = Math.min(min, Math.min(a, b));
            }
        }

        System.out.println(min);
    }
}