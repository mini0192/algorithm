class Solution {
   public int solution(int n, int[] stations, int w) {
        double max = 2 * w + 1;
        double num = 1;

        int answer = 0;

        for(int station : stations) {
            if(station - w > 0)
                answer += (int) Math.ceil(((station - w) - num) / max);
            num = station + w + 1;
        }

        if(num - 1 < n)
            return (int) Math.ceil((n - (num - 1))/max) + answer;

        return answer;
    }
}