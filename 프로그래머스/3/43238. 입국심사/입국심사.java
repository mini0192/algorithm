import java.util.*;
class Solution {
    int[] timeArr;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        timeArr = times;

        long start = 0;
        long end = Long.MAX_VALUE / 100;
        while(start < end) {
            long mid = (start + end) / 2;
            long c = check(mid);
            if(c >= n) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    private long check(long check) {
        long sum = 0;
        for(int time : timeArr) {
            sum += check / time;
        }
        return sum;
    }
}