class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] sumA = new int[sticker.length - 1];
        sumA[0] = sticker[0];
        sumA[1] = sticker[0];

        for(int i = 2; i < sticker.length - 1; i++) {
            sumA[i] = Math.max(sumA[i - 1], sumA[i - 2] + sticker[i]);
        }

        int[] sumB = new int[sticker.length];
        sumB[0] = 0;
        sumB[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++) {
            sumB[i] = Math.max(sumB[i - 1], sumB[i - 2] + sticker[i]);
        }

        return Math.max(sumA[sumA.length - 1], sumB[sumB.length - 1]);
    }
}