import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String c : completion) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c, 0);
        }
        
        for(String p : participant) {
            if(!map.containsKey(p)) return p;
            if(map.get(p) < 0) return p;
            map.put(p, map.get(p) - 1);
        }
        
        return null;
    }
}