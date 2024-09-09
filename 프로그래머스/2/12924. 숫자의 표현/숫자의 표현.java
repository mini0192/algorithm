class Solution {
    int n;
    int answer;

    private void loop(int min) {
        if(min >= n) return;

        int sum = 0;
        for(int i = min; i < n; i++) {
            sum += i;
            if(sum == n) {
                answer++;
                break;
            }
            if(sum > n) break;
        }

        loop(min + 1);
    }
    public int solution(int n) {
        this.n = n;

        answer = 1;
        loop(1);

        return answer;
    }
}