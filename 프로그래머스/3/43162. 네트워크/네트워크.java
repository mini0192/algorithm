import java.util.Stack;

class Solution {
    public int solution(int n, int[][] computers) {
        Stack<int[]> stack = new Stack<>();
        boolean[] check = new boolean[computers.length];
        int answer = 0;

        for(int j = 0; j < n; j++) {
            if(check[j]) continue;
            stack.push(computers[j]);
            check[j] = true;
            answer++;

            while (!stack.empty()) {
                int[] data = stack.pop();
                for (int i = 0; i < data.length; i++) {
                    if (data[i] == 1 && !check[i]) {
                        stack.push(computers[i]);
                        check[i] = true;
                    }
                }
            }
        }
        return answer;
    }
}