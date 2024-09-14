import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    private static int[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] check = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(line);

        for(int c : check) {
            if(check(0, line.length - 1, c)) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }

    private static boolean check(int start, int end, int number) {
        if(line[start] == number || line[end] == number) return true;

        int mid = (start + end) / 2;
        if(mid == start || mid == end) return false;

        if(number == line[mid]) return true;
        if(number < line[mid]) return check(start, mid, number);
        if(number > line[mid]) return check(mid, end, number);

        return false;
    }
}