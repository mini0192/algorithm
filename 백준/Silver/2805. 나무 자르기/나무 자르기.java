import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        long[] data = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long start = 0;
        long end = Arrays.stream(data).max().getAsLong();

        while(start <= end) {
            long mid = (start + end) / 2;
            long get = 0;

            for(long d : data) {
                long h = d - mid;
                get += h > 0 ? h : 0;
            }

            if(get >= M) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
    }
}