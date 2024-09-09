import java.util.*;

class Solution {
    
    String[] user;
    String[] banned;

    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        banned = banned_id;

        List<String> data = dfs(0, null);
        List<String> dataSort = new ArrayList<>();

        for(String d : data) {
            char[] c = d.toCharArray();
            Arrays.sort(c);
            dataSort.add(String.valueOf(c));
        }

        Set<String> dataSet = new HashSet<>(dataSort);
        return dataSet.size();
    }

    private List<String> dfs(int index, String check) {
        if(banned.length <= index) return null;
        String dfsBan = banned[index];
        List<String> data = new ArrayList<>();

        for(int i = 0; i < user.length; i++) {
            if(checker(check, i)) continue;

            String dfsUser = user[i];
            if(!checkStr(dfsBan, dfsUser)) continue;

            String giveCheck = check == null ? Integer.toString(i) : check + i;
            List<String> rtnData = dfs(index + 1, giveCheck);
            if(rtnData == null) data.add(Integer.toString(i));
            else {
                int finalI = i;
                rtnData.forEach(d -> data.add(d + finalI));
            }
        }
        return data;
    }

    private boolean checkStr(String s, String target) {
        if(s.length() != target.length()) return false;

        char[] sCharList = s.toCharArray();
        char[] targetCharList = target.toCharArray();

        for(int i = 0; i < sCharList.length; i++) {
            if(sCharList[i] == '*') continue;
            if(sCharList[i] != targetCharList[i]) return false;
        }

        return true;
    }

    private boolean checker(String check, int target) {
        if(check == null) return false;
        char[] c = check.toCharArray();

        for(char loop : c) {
            if(loop == target + '0') return true;
        }
        return false;
    }
}