class Solution {
    public long solution(int[] sequence) {
        long maxA = sequence[0];
        long maxB = sequence[0] * -1;
        
        long max = Math.max(sequence[0], sequence[0] * -1);
        
        boolean status = true;
        
        for(int i = 1; i < sequence.length; i++) {
            maxA = Math.max(0, maxA) + (!status ? sequence[i] : (sequence[i] * -1));
            maxB = Math.max(0, maxB) + (status ? sequence[i] : (sequence[i] * -1));
            
            long localMax = Math.max(maxA, maxB);
            max = Math.max(max, localMax); 
            
            status = !status;
        }
        
        return max;
    }
}