import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 1}); // x, y, step
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put("0:0", true);
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        while(!que.isEmpty()) {
            int[] data = que.poll();
            int x = data[0];
            int y = data[1];
            int step = data[2];
            
            if(y == n - 1 && x == m - 1) {
                return step;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && maps[ny][nx] == 1) {
                    String key = nx + ":" + ny;
                    if(!visited.containsKey(key)) {
                        visited.put(key, true);
                        que.add(new int[]{nx, ny, step + 1});
                    }
                }
            }
        }
        return -1;
    }
}