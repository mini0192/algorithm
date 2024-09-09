import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> cache = new HashMap<>();
        
        int count = 1;
        int user = 1;
        
        char last = '=';
        for(String word : words) {
            char s = word.charAt(0);
            if(last != '=' && s != last) return new int[]{user,count};
            
            if(cache.containsKey(word)) return new int[]{user,count};
            cache.put(word, true);
            
            last = word.charAt(word.length() - 1);
            System.out.println(last);
            
            user++;
            if(user > n) {
                user = 1;
                count++;
            }
        }

        return new int[]{0, 0};
    }
}