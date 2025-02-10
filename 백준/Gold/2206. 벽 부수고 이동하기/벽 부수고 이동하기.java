import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, broken, count;

        public Node(int y, int x, int broken, int count) {
            this.y = y;
            this.x = x;
            this.broken = broken;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] map = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            String line = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][][] visited = new int[Y][X][2]; // 0: 벽 안 부숨, 1: 벽 부숨
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = 1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == X - 1 && cur.y == Y - 1) {
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nbroken = cur.broken;

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y) continue;

                if (map[ny][nx] == 1 && nbroken == 0) { // 벽을 처음 부순 경우
                    visited[ny][nx][1] = 1;
                    q.add(new Node(ny, nx, 1, cur.count + 1));
                } else if (map[ny][nx] == 0 && visited[ny][nx][nbroken] == 0) { // 벽이 아닐 경우
                    visited[ny][nx][nbroken] = 1;
                    q.add(new Node(ny, nx, nbroken, cur.count + 1));
                }
            }
        }

        System.out.println("-1");
    }
}
