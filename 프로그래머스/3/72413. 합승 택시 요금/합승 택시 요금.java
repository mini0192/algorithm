import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n][n];
        final int INF = 100000000;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == i) cost[i][j] = 0;
                else cost[i][j] = INF;
            }
        }
        
        
        for(int[] fare : fares) {
            int positionA = fare[0] - 1;
            int positionB = fare[1] - 1;
            int costs = fare[2];
            
            cost[positionA][positionB] = costs;
            cost[positionB][positionA] = costs;
        }
        
        for(int i = 0; i < n; i++) {
            for(int num1 = 0; num1 < n; num1++) {
                for(int num2 = 0; num2 < n; num2++) {
                    cost[num1][num2] = Math.min(cost[num1][num2], cost[num1][i] + cost[i][num2]);
                }
            }
        }
        
        int answer = INF;
        for(int i = 0; i < n; i++) {
            answer = Math.min(cost[s - 1][i] + cost[i][a - 1] + cost[i][b - 1], answer);
        }
        
        return answer;
    }
}