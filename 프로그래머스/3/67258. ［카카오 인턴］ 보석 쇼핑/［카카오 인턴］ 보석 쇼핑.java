import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(List.of(gems));
        if(set.size() == 1) return new int[]{1, 1};

        Map<String, Integer> dataMap = new HashMap<>();
        Set<String> dataSet = new HashSet<>();

        dataMap.put(gems[gems.length - 1], gems.length - 1);
        dataSet.add(gems[gems.length - 1]);

        int start = gems.length - 1;
        int end = gems.length - 1;
        int min = 100001;

        int[] rtn = new int[2];

        while(true) {
            if(end - start > min) {
                end--;
                if(end < start) start--;
                int position = dataMap.get(gems[end + 1]);
                if(position == end + 1) dataSet.remove(gems[end + 1]);
                continue;
            }

            if(dataSet.size() != set.size()) {
                start--;
                if(start < 0) break;
                dataMap.put(gems[start], start);
                dataSet.add(gems[start]);
                continue;
            }

            min = end - start;
            rtn[0] = start; rtn[1] = end;

            end--;
            if(end < start) start--;
            int position = dataMap.get(gems[end + 1]);
            if(position == end + 1) dataSet.remove(gems[end + 1]);
        }

        int[] answer = new int[]{rtn[0] + 1, rtn[1] + 1};
        return answer;
    }
}