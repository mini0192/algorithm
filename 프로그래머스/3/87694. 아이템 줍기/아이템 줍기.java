import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];
        boolean[][] visited = new boolean[102][102];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (x1 < i && i < x2 && y1 < j && j < y2) {
                        board[i][j] = 2;
                    } else if (board[i][j] != 2) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == itemX * 2 && y == itemY * 2) {
                return dist / 2;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102 && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}
