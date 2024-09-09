class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vidioLen = toNumber(video_len);
        
        int opStart = toNumber(op_start);
        int opEnd = toNumber(op_end);
        
        int point = toNumber(pos);
        
        for(String c : commands) {
            if(point >= opStart && point <= opEnd) point = opEnd;
            
            if(c.equals("next")) {
                point += 10;
                if(point > vidioLen) point = vidioLen;
            }
            
            if(c.equals("prev")) {
                point -= 10;
                if(point < 0) point = 0;
            }
        }
        
        if(point >= opStart && point <= opEnd) point = opEnd;
        return toTime(point);
    }
    
    private int toNumber(String time) {
        String[] t = time.split(":");
        
        int h = Integer.valueOf(t[0]);
        int m = Integer.valueOf(t[1]);
        
        return (h * 60) + m;
    }
    
    private String toTime(int number) {
        int h = number / 60;
        int m = number % 60;
        
        return String.format("%02d", h) + ":" + String.format("%02d", m);
    }
}