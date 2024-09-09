class Solution {
    public int[] solution(int brown, int yellow) {
        int h = 2;
        int total = brown + yellow;
        while(true) {
            h++;
            if(total % h != 0) continue;
            int w = total / h;
            if((w - 2) * (h - 2) == yellow) return new int[]{w, h};
        }
    }
}