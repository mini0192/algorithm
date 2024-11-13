import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] datas = new int[N];
        String[] inData = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            datas[i] = Integer.parseInt(inData[i]);
        }
        Arrays.sort(datas);

        long minAbs = Long.MAX_VALUE;

        int rtnLow = 0;
        int rtnHigh = datas.length - 1;

        int low = 0;
        int high = datas.length - 1;

        while(low < high) {
            int sum = datas[low] + datas[high];

            int abs = Math.abs(sum);
            if(abs == 0) {
                rtnLow = low;
                rtnHigh = high;
                break;
            }

            if(abs <= minAbs) {
                minAbs = abs;
                rtnLow = low;
                rtnHigh = high;
            }

            if(sum < 0) {
                low++;
            } else if(sum > 0) {
                high--;
            }
        }

        System.out.println(datas[rtnLow] + " " + datas[rtnHigh]);
    }
}

