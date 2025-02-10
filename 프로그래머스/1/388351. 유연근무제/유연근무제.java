class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        boolean[] checkers = new boolean[schedules.length];
        
        for(int count = 0; count < 7; count++) {
            int day = dayCal(startday, count);
            if(day == 6 || day == 7) continue;
            
            for(int member = 0; member < schedules.length; member++) {
                if(checkers[member]) continue;
                int schedule = maketime(schedules[member]);
                int timelog = maketime(timelogs[member][count]);
                if(timelog > schedule + 10) checkers[member] = true;
            }
        }
        
        int count = 0;
        for(boolean checker : checkers) {
            if(!checker) count++;
        }
        return count;
    }
    
    private int dayCal(int startday, int count) {
        int day = startday + count;
        if(day > 7) return day - 7;
        return day;
    }
    
    private int maketime(int time) {
        int h = (time / 100) * 60;
        int m = time % 100;
        return h + m;
    }
}