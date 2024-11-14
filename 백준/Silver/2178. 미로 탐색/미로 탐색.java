import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        boolean[][] map = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                if(data[j].equals("1")) map[i][j] = true;
            }
        }

        boolean[][] check = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N - 1, M - 1, 1});

        while(!queue.isEmpty()) {
            int[] data = queue.poll();

            int n = data[0];
            int m = data[1];
            int count = data[2];

            if(n == 0 && m == 0) {
                System.out.println(count);
                return;
            }

            try {
                if (!check[n - 1][m] && map[n - 1][m]) {
                    queue.add(new int[]{n - 1, m, count + 1});
                    check[n - 1][m] = true;
                }
            } catch(Exception e) {}

            try {
                if(!check[n + 1][m] && map[n + 1][m]) {
                    queue.add(new int[]{n + 1, m, count + 1});
                    check[n + 1][m] = true;
                }
            } catch(Exception e) {}

            try {
                if(!check[n][m - 1] && map[n][m - 1]) {
                    queue.add(new int[]{n, m - 1, count + 1});
                    check[n][m - 1] = true;
                }
            } catch(Exception e) {}

            try {
                if(!check[n][m + 1] && map[n][m + 1]) {
                    queue.add(new int[]{n, m + 1, count + 1});
                    check[n][m + 1] = true;
                }
            } catch(Exception e) {}
        }
    }
}
