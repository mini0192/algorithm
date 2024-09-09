import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int checkData = s / n;
        if(checkData == 0) return new int[]{-1};
        
        int checkData2 = s % n;
        int[] answerList = new int[n];
        Arrays.fill(answerList,checkData);

        for(int i = 0; i < checkData2; i++) answerList[n - i - 1]++;

        return answerList;
    }
}