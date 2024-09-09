import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] sum = new int[elements.length * 2];
        
        sum[0] = elements[0];
        for(int i = 1; i < sum.length - 1; i++) {
            if(i > elements.length - 1) sum[i] = sum[i - 1] + elements[i - elements.length];
            else sum[i] = sum[i - 1] + elements[i];
        }
        
        Set<Integer> answerSet = new HashSet<>();
        for(int index = 1; index < elements.length + 1; index++) {
            for(int i = 0; i < elements.length; i++) {
                int answer = sum[index + i] - sum[i];
                if(answer < 0) continue;
                answerSet.add(answer);
            }
        }
        return answerSet.size();
    }
}