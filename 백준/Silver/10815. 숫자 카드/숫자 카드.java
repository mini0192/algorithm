import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        long[] get = Stream.of(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        long[] check = Stream.of(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();

        Arrays.sort(get);

        for(long c : check) {

            int start = 0;
            int end = N - 1;

            while (true) {
                if(start > end) {
                    sb.append("0 ");
                    break;
                }

                int mid = (start + end) / 2;

                if(get[mid] == c) {
                    sb.append("1 ");
                    break;
                } else if(get[mid] < c) start = mid + 1;
                else end = mid - 1;
            }
        }

        System.out.println(sb);
    }
}