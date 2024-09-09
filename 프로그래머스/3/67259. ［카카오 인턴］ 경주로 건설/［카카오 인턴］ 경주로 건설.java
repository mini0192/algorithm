import java.util.*;

class Solution {
    public int solution(int[][] board) {
        Set<Integer> rtn = new HashSet<>();
        Map<String, Integer> checker = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        
        String firstAdd = (board.length - 1) + "/" + (board[0].length - 1) + "/" + "0" + "/" + 0;
        que.add(firstAdd);
        
        int min = -1;
        
        while(!que.isEmpty()) {
            String str = que.poll();
            String[] s = str.split("/");
            
            int x = Integer.valueOf(s[0]);
            int y = Integer.valueOf(s[1]);
            int cost = Integer.valueOf(s[3]);
            String last = s[2];
            
            System.out.println(x + " : " + y + " / " + cost + " / " + last);
            
            if(x == 0 && y == 0) {
                if(min == -1 || min > cost) min = cost;
                continue;
            };
            
            String checkStr = x + "/" + y;
            if(checker.containsKey(checkStr) && checker.get(checkStr) < cost) continue;
            checker.put(checkStr, cost);
            
            
            // 위로 건설
            if(!last.equals("d") && y > 0 && board[y - 1][x] != 1) {
                int costAdd = 100;
                if(!last.equals("u")) costAdd += 500;
                String add = x + "/" + (y - 1) + "/" + "u" + "/" + (cost + costAdd);
                que.add(add);
            }
            
            // 아래 건설
            if(!last.equals("u") && y < board.length - 1 && board[y + 1][x] != 1) {
                int costAdd = 100;
                if(!last.equals("d")) costAdd += 500;
                String add = x + "/" + (y + 1) + "/" + "d" + "/" + (cost + costAdd);
                que.add(add);
            }
            
            // 왼쪽 건설
            if(!last.equals("r") && x > 0 && board[y][x - 1] != 1) {
                int costAdd = 100;
                if(!last.equals("l")) costAdd += 500;
                String add = (x - 1) + "/" + y + "/" + "l" + "/" + (cost + costAdd);
                que.add(add);
            }
            
            // 오른쪽 건설
            if(!last.equals("l") && x < board.length - 1 && board[y][x + 1] != 1) {
                int costAdd = 100;
                if(!last.equals("r")) costAdd += 500;
                String add = (x + 1) + "/" + y + "/" + "r" + "/" + (cost + costAdd);
                que.add(add);
            }
        }
        
        return min - 500;
    }
}