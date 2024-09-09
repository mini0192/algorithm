import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        List<Integer> data = new ArrayList<>();
        
        for(String d : str) {
            data.add(Integer.valueOf(d));
        }
        return Collections.min(data) + " " + Collections.max(data);
    }
}