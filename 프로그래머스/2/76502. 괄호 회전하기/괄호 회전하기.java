import java.util.*;

class Solution {
    public int solution(String s) {
        int size = s.split("").length;
        int rtn = 0;
        
        String data = s;
        for(int i = 0; i < size; i++) {
            if(check(data)) rtn++;
            data = makeString(data);
        }
        return rtn;
    }
    
    private String makeString(String s) {
        String[] data = s.split("");
        String rtn = "";
        for(int i = 1; i < data.length; i++) {
            rtn += data[i];
        }
        rtn += data[0];
        return rtn;
    }
    
    private boolean check(String s) {
        Stack<String> stack = new Stack<>();
        String[] str = s.split("");
        
        for(String data : str) {
            if(data.equals("(")) {
                stack.push(data); continue;
            }
            if(data.equals("{")) {
                stack.push(data); continue;
            }
            if(data.equals("[")) {
                stack.push(data); continue;
            }
            
            if(stack.isEmpty()) return false;
            
            String rtn = stack.pop();
            if(rtn.equals("(") && data.equals(")")) continue;
            if(rtn.equals("{") && data.equals("}")) continue;
            if(rtn.equals("[") && data.equals("]")) continue;
            return false;
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}