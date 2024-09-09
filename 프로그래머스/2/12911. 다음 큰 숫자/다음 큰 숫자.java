import java.util.*;

class Solution {
    public int solution(int n) {
        int number = Integer.bitCount(n);

        int answer = n;
        while(true) {
            answer++;
            int rtn = Integer.bitCount(answer);
            if(rtn == number) return answer;
        }
    }
}