import java.util.*;

class Solution {
    Map<String, Boolean> check = new HashMap<>();
    Stack<String> stack = new Stack<>();

    public int solution(String begin, String target, String[] words) {
        List<Integer> answerList = new ArrayList<>();

        Arrays.stream(words).forEach(data -> {
            String checkStr = begin;
            if(!checkStr(data, checkStr)) return;

            stack.push(data);
            int answer = 0;

            while(!stack.empty()) {

                answer++;
                String str = stack.pop();
                check.put(str, true);
                if(str.equals(target)) answerList.add(answer);

                for(String loop : words) {
                    if(checkStr(loop, str)) {
                        if(!check.containsKey(loop))
                            stack.push(loop);
                    }
                }
            }
        });

        if(answerList.isEmpty()) return 0;
        return Collections.min(answerList);
    }

    private boolean checkStr(String str, String checkStr) {
        char[] charArr = str.toCharArray();
        char[] charCheckArr = checkStr.toCharArray();

        boolean check = true;

        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] != charCheckArr[i]) {
                if(check) check = false;
                else return false;
            }
        }

        return !check;
    }
}