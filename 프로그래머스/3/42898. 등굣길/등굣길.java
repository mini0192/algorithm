class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int NOP = -1;
        int[][] check = new int[n][m];

        for(int[] puddle : puddles) {
            check[puddle[1] - 1][puddle[0] - 1] = NOP;
        }

        for(int y = 1; y < n; y++) {
            if(check[y][0] == NOP) break;
            if(check[y - 1][0] == NOP) break;
            check[y][0] = 1;
        }

        for(int x = 1; x < m; x++) {
            if(check[0][x] == NOP) break;
            if(check[0][x - 1] == NOP) break;
            check[0][x] = 1;
        }

        for(int y = 1; y < n; y++) {
            for(int x = 1; x < m; x++) {
                if(check[y][x] == NOP) continue;

                int checkNumA = check[y][x - 1] == NOP ? 0 : check[y][x - 1];
                int checkNumB = check[y - 1][x] == NOP ? 0 : check[y - 1][x];
                check[y][x] = (checkNumA + checkNumB) == 0 ? NOP : (checkNumA + checkNumB) % 1_000_000_007;
            }
        }
        
        if(check[n-1][m-1] == NOP) return 0;
        return check[n-1][m-1];
    }
}