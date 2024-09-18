import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(br.readLine().split(" "));
        }

       Collections.sort(list, (o1, o2) -> Integer.parseInt(o1[0]) - (Integer.parseInt(o2[0])));

        for(String[] s : list) {
            sb.append(s[0] + " " + s[1] + "\n");
        }

        System.out.println(sb);
    }
}