class Solution {
    int index = 0;
    int deleteZeroCount = 0;

    private void loopFunc(String s) {
        if(s.equals("1")) return;
        index++;

        String[] sArr = s.split("");
        String getStr = "";
        
        for(String sLoop : sArr) {
            if(sLoop.equals("0")) {
                deleteZeroCount++;
            } else {
                getStr += "1";
            }
        }
        getStr = Integer.toBinaryString(getStr.length());
        loopFunc(getStr);
    }
    
    public int[] solution(String s) {
        loopFunc(s);
        return new int[]{index, deleteZeroCount};
    }
}