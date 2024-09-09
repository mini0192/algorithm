import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int max = people.length - 1;
        int min = 0;
        
        int count = 0;
        int sum = 0;
        
        while(max >= min) {
            sum += people[max];
            max--;
            
            if(sum + people[min] <= limit) {
                sum += people[min];
                min++;
            }
            
            sum = 0;
            count++;
        }
        
        return count;
    }
}