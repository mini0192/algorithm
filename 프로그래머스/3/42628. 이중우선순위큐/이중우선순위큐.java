import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String data : operations) {
            String[] d = data.split(" ");
            int value = Integer.valueOf(d[1]);
            if(d[0].equals("I")) {
                min.add(value);
                max.add(value);
                continue;
            }
            if(d[0].equals("D")) {
                if(value == 1) {
                    if(min.isEmpty()) continue;
                    int a = min.poll();
                    max.remove(a);
                }
                if(value == -1) {
                    if(max.isEmpty()) continue;
                    int a = max.poll();
                    min.remove(a);
                }
            }
        }
        if(min.size() == 0) return new int[]{0, 0};
        return new int[]{min.poll(), max.poll()};
    }
}