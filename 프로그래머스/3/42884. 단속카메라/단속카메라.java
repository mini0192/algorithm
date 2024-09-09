import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) ->o2[0] - o1[0]);
        int answer = 0;
        int gate = 30001;
        for(int[] route : routes) {
            if(route[1] < gate) {
                if(route[0] < gate) {
                    gate = route[0];
                    answer++;
                }
            }
        }
        return answer;
    }
}