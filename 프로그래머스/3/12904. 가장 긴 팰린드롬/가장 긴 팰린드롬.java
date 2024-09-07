import java.util.*;

class Solution
{
    public int solution(String s)
    {
        List<Character> data = new ArrayList<>();
        List<Integer> rtn = new ArrayList<>();
        
        for(String str : s.split("")) {
            char c = str.charAt(0);
            data.add('#');
            data.add(c);
        }
        data.add('#');
        
        for(int i = 0; i < data.size(); i++) {
            int size = -1;
            while(true) {
                size++;
                int indexA = i - size;
                int indexB = i + size;
                if(indexA < 0) break;
                if(data.size() - 1 < indexB) break;
                
                char dataA = data.get(indexA);
                char dataB = data.get(indexB);
                
                if(dataA == dataB) continue;
                break;
            }
            
            rtn.add(size);
        }
        
        return Collections.max(rtn) - 1;
    }
}