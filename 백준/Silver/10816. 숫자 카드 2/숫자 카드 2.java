import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        br.readLine();
        int[] list = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.readLine();
        int[] check = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(list);

        for(int c : check) {
            sb.append(upper(list, c) - lower(list, c)).append(" ");
        }


        System.out.println(sb);
    }

    private static int upper(int[] line, int number) {
        int start = 0;
        int end = line.length;

        while(start < end) {
            int mid = (start + end) / 2;
            if(number < line[mid]) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    private static int lower(int[] line, int number) {
        int start = 0;
        int end = line.length;

        while(start < end) {
            int mid = (start + end) / 2;
            if(number <= line[mid]) end = mid;
            else start = mid + 1;
        }

        return start;
    }
}