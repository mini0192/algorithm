import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        long max = Integer.MIN_VALUE;
        long[] home = new long[N];
        for(int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, home[i]);
        }

        long start = 0;
        long end = max + 1;

        Arrays.sort((home));

        while(start < end) {
            long mid = (start + end) / 2;

            long rtn = 0;
            long last = Long.MIN_VALUE;

            for(long h : home) {
                if(h >= last + mid) {
                    rtn++;
                    last = h;
                }
            }

            if(rtn >= C) start = mid + 1;
            else end = mid;
        }

        System.out.println(end - 1);
    }
}