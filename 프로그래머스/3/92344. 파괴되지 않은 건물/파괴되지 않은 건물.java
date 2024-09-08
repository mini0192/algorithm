class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int[][] checker = new int[board.length + 1][board[0].length + 1];
        
        for(int[] s : skill) {
            int target = s[0];
            
            int startX = s[1];
            int startY = s[2];
            
            int endX = s[3] + 1;
            int endY = s[4] + 1;
            
            int power = s[0] == 2 ? s[5] : s[5] * -1;
            
            checker[startX][startY] += power;
            checker[endX][startY] -= power;
            checker[startX][endY] -= power;
            checker[endX][endY] += power;
        }
        
        for(int i = 1; i < checker.length; i++) {
            for(int j = 0; j < checker[0].length; j++) {
                checker[i][j] = checker[i - 1][j] + checker[i][j];
            }
        }

        for(int i = 1; i < checker[0].length; i++) {
            for(int j = 0; j < checker.length; j++) {
                checker[j][i] = checker[j][i - 1] + checker[j][i];
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] + checker[i][j] > 0) count++;
            }
        }

        return count;
    }
}