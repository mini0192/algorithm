import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] data : clothes) {
            String key = data[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int answer = 1;
        for(int data : map.values()) {
            answer *= (data + 1);
        }
        return answer - 1;
    }
}