import java.util.*;

class Solution {
    
    int[] check;

    int find(int n) {
        if(check[n] == n) return n;
        return find(check[n]);
    }

    boolean union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        if(n1 == n2) return false;

        if(n1 < n2) check[n2] = n1;
        else check[n1] = n2;

        return true;
    }

    public int solution(int n, int[][] costs) {
        check = new int[n];
        for(int i = 0; i < n; i++) {
            check[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int answer = 0;
        for(int[] cost : costs) {
            if(!union(cost[0], cost[1])) continue;
            answer += cost[2];
        }

        return answer;
    }
}