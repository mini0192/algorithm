import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int data : tangerine) {
            if(!map.containsKey(data)) {
                map.put(data, 1);
                continue;
            }
            int getMap = map.get(data);
            if(getMap + 1 > k) continue;
            if(getMap + 1 == k) return 1;
            map.put(data, getMap + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int count = 1;
        int sum = 0;
        for(Integer data : list) {
            sum += data;
            if(sum >= k) return count;
            count++;
        }
        
        return 0;
    }
}