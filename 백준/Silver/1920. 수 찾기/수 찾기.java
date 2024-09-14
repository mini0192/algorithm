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
        int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] check = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(line);

        for(int c : check) {
            if(check(line, c)) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }

    private static boolean check(int[] line, int number) {
        int start = 0;
        int end = line.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(line[mid] == number) return true;
            else if(line[mid] > number) end = mid - 1;
            else if(line[mid] < number) start = mid + 1;
        }

        return false;
    }
}