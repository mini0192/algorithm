import java.util.Stack;

class Solution {
    private int timeToInt(String time) {
        String[] timeStringList = time.split(":");
        int[] timeIntList = new int[2];

        timeIntList[0] = Integer.parseInt(timeStringList[0]);
        timeIntList[1] = Integer.parseInt(timeStringList[1]);

        return (timeIntList[0] * 60) + timeIntList[1];
    }

    private int timeToIntMinute(String time) {
        return Integer.parseInt(time);
    }

    public String[] solution(String[][] plans) {
        Stack<String> homework = new Stack<>();
        Stack<Integer> workTimmer = new Stack<>();

        String[] answer = new String[plans.length];
        int index = 0;

        int[] homeworkTime = new int[plans.length];

        for(int i = 0; i < plans.length; i++) {
            homeworkTime[i] = timeToInt(plans[i][1]);
        }

        int timmer = 0;
        while(true) {
            try {
                int stackTimmer = workTimmer.pop() - 1;

                if(stackTimmer == 0) {
                    answer[index] = homework.pop();
                    index++;
                    if(index == plans.length) return answer;
                } else {
                    workTimmer.push(stackTimmer);
                }

            } catch (Exception e) {}

            for(int i = 0; i < plans.length; i++) {
                if(homeworkTime[i] == timmer) {
                    homework.push(plans[i][0]);
                    workTimmer.push(timeToIntMinute(plans[i][2]));
                }
            }
            timmer++;
        }
    }
}