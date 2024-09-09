import java.util.*;

class Solution {
    
    private Map<String, Boolean> cache;
    
    public boolean solution(String[] phone_book) {
        cache = new HashMap<>();
        for(String number : phone_book) {
            if(!cache.isEmpty() && check(number)) return false;
            cache.put(number, true);
        }
        
        cache = new HashMap<>();
        for(int i = phone_book.length - 1; i >= 0; i--) {
            if(!cache.isEmpty() && check(phone_book[i])) return false;
            cache.put(phone_book[i], true);
        }
        
        return true;
    }
    
    private boolean check(String target) {
        String[] targetArr = target.split("");
        String str = "";
        
        for(String t : targetArr) {
            str += t;
            if(cache.containsKey(str)) return true;
        }
        
        return false;
    }
}