class Solution {
    long[] cache;
    
    public long solution(int n) {
        cache = new long[n + 1];
        return f(n);
    }
    
    private long f(int n) {
        if(n == 1 || n == 2) return n;
        
        if(cache[n] != 0) return cache[n];
        
        long n1 = f(n - 1);
        long n2 = f(n - 2);
        
        cache[n] = (n1 + n2) % 1234567;
        return (n1 + n2) % 1234567;
    }
}