import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        List<int[]> jobList = new LinkedList<>();
        Collections.addAll(jobList, jobs);
        Collections.sort(jobList, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int time = 0;
        int sum = 0;

        while(true) {
            if(jobList.isEmpty() && queue.isEmpty()) break;
            while(!jobList.isEmpty()) {
                if(jobList.get(0)[0] <= time) {
                    queue.add(jobList.get(0));
                    jobList.remove(0);
                } else break;
            }
            if(!queue.isEmpty()) {
                int[] getQueue = queue.poll();
                time += getQueue[1];
                sum += time - getQueue[0];
            } else time++;
        }

        return sum/ jobs.length;
    }
}