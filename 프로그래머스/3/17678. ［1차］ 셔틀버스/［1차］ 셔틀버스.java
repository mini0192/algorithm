import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int startTime = takenTime("09:00");
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int i = 0; i < timetable.length; i++) {
            que.add(takenTime(timetable[i]));
        }
        
        int count = 0;
        int max = m;
        
        while(!que.isEmpty()) {
            if(count == n - 1) break;
            
            int time = startTime + (count * t);
            int people = que.poll();
            
            if(time >= people) {
                max--;
                System.out.println(makeTime(time) + "에 탑승: " + makeTime(people));
                if(max == 0) {
                    max = m;
                    count++;
                    System.out.println(makeTime(time) + " 버스 인원 초과로 출발");
                }
            } else {
                que.add(people);
                count++;
                System.out.println(makeTime(time) + " 버스 늦게와서 먼저 출발");
            }
        }
        
        int time = startTime + ((n - 1) * t);
        System.out.println(makeTime(time) + " 마지막 버스 시간");
        
        int num = 0;
        while(!que.isEmpty()) {
            int people = que.poll();
            if(time >= people) {
                System.out.println(makeTime(time) + " 마지막 버스 탑승 : " + makeTime(people));
                num++;
            }
            else break;
            
            if(num == m) {
                System.out.println(makeTime(time) + " 마지막에 탑승한 사람의 1분 전에 탑승 : " + makeTime(people - 1));
                return makeTime(people - 1);
            }
        }
        
        System.out.println(makeTime(time) + " 버스 시간에 맞춰서 탑승 : " + makeTime(time));
        return makeTime(time);
    }
    
    private int takenTime(String takenTime) {
        String[] time = takenTime.split(":");
        return (Integer.valueOf(time[0]) * 60) + Integer.valueOf(time[1]);
    }
    
    private String makeTime(int time) {
        return String.format("%02d", (time / 60)) + ":" + String.format("%02d", (time % 60));
    }
}