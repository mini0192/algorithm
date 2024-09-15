import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int K = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        long max = Long.MIN_VALUE;
        long[] data = new long[K];

        for(int i = 0; i < K; i++) {
            data[i] = Long.parseLong(br.readLine());
            max = Math.max(data[i], max);
        }

        long start = 0;
        long end = max + 1;

        while(start <= end) {
            long mid = (start + end) / 2;
            if(mid == 0) mid = 1;
            
            long rtn = 0;

            for(long d : data) {
                rtn += d / mid;
            }

            if(rtn >= N) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(end);
    }
}