import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] rtn = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] datas = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(datas);
            rtn[i] = datas[command[2] - 1];
        }
        return rtn;
    }
}