import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int l = 0;
        int r = Arrays.stream(stones).max().getAsInt();

        while (l <= r) {
            int m = (l + r) / 2;

            int sequence = 0;
            int maxSequence = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - m <= 0) {
                    sequence++;
                    maxSequence = Math.max(maxSequence, sequence);
                } else {
                    sequence = 0;
                }
            }

            if (maxSequence + 1 > k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}