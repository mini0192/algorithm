import java.util.*;

class Solution {
    int[] cash;
    
    public int solution(int n) {
        cash = new int[100001];
        return f(n);
    }
    
    private int f(int data) {
        if(data == 0) return 0;
        if(data == 1) return 1;
        
        int r1;
        if(cash[data - 1] != 0)
            r1 = cash[data - 1];
        else {
            r1 = f(data - 1);
            cash[data - 1] = r1;
        }
        
        int r2;
        if(cash[data - 2] != 0)
            r2 = cash[data - 2];
        else {
            r2 = f(data - 2);
            cash[data - 2] = r2;
        }
        return (r1 + r2) % 1234567;
    }
}