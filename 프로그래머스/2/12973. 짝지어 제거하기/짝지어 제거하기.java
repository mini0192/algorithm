import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char nowData = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(nowData);
                continue;
            }
            char data = stack.pop();
            if(data == nowData) continue;
            
            stack.push(data);
            stack.push(nowData);
        }
        
        if(stack.size() == 0) return 1;
        return 0;
    }
}