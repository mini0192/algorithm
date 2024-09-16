import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;

        while(start < end) {
            long mid = (start + end) / 2;

            long rtn = 0;
            for(int i = 1; i <= N; i++) {
                rtn += Math.min(mid / i, N);
            }

            if(K > rtn) start = mid + 1;
            else end = mid;
        }

        System.out.println(end);
    }
}