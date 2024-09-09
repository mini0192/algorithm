import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        for(int[] e : edge) {
            List<int[]> list;

            list = edgeMap.get(e[0]);
            if(list == null) list = new ArrayList<>();
            list.add(e);
            edgeMap.put(e[0], list);

            list = edgeMap.get(e[1]);
            if(list == null) list = new ArrayList<>();
            list.add(e);
            edgeMap.put(e[1], list);
        }

        int[] count = new int[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, -1});

        while(!queue.isEmpty()) {
            int[] que = queue.poll();
            int node = que[0];
            int cnt = que[1] + 1;

            if(count[node] != 0) continue;
            count[node] = cnt;

            List<int[]> list = edgeMap.get(node);
            list.forEach(d -> {
                if(d[0] == node) queue.add(new int[]{d[1], cnt});
                else queue.add(new int[]{d[0], cnt});
            });
        }
        count[1] = 0;
        int max = 0;
        int answer = 0;
        for(int c : count) {
            if(c > max) {
                max = c;
                answer = 1;
                continue;
            }
            if (c == max) answer++;
        }

        return answer;
    }
}