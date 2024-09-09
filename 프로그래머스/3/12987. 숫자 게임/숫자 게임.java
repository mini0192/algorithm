import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int count = 0;

        for(int b = 0; b < B.length; b++) {
            if(B[b] > A[count]) {
                count++;
                answer++;
            }
        }
        return answer;
    }
}