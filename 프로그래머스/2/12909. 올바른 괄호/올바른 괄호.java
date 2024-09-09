import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0;
        String[] str = s.split("");
        
        if(str[0].equals(")")) return false;
        count++;
        
        for(int i = 1; i < str.length; i++) {
            if(str[i].equals(")")) {
                if(count == 0) return false;
                count--;
            }
            else {
                count++;
                if(count > str.length - i) return false;
            }
        }
        
        if(count == 0) return true;
        return false;
    }
}