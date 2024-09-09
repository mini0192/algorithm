import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answer = new ArrayList<>();

        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for(int i = 0; i < genres.length; i ++) {
            List<int[]> get = map.get(genres[i]);
            if(get == null) get = new ArrayList<>();
            get.add(new int[]{plays[i], i});
            map.put(genres[i], get);

            Integer cnt = count.get(genres[i]);
            if(cnt == null) cnt = 0;
            cnt += plays[i];
            count.put(genres[i], cnt);
        }

        List<String> sortList = new ArrayList<>(count.keySet());
        sortList.sort((o1, o2) -> Integer.compare(count.get(o2), count.get(o1)));

        for(String sort : sortList) {
            List<int[]> get = map.get(sort);
            Collections.sort(get, (o1, o2) -> o2[0] - o1[0]);

            for(int i = 0; i < get.size() && i < 2; i++) {
                answer.add(get.get(i)[1]);
            }
        }

        int[] retnData = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            retnData[i] = answer.get(i);
        }

        return retnData;
    }
}