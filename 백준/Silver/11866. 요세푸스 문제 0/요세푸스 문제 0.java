import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        boolean[] cache = new boolean[N + 1];

        int index = 0;
        List<Integer> rtn = new ArrayList<>();
        while(rtn.size() != N) {
            for(int i = 0; i < K; i++) {
                index++;
                if(index > N) index -= N;
                while(cache[index]) {
                    index++;
                    if(index > N) index -= N;
                }
            }
            cache[index] = true;
            rtn.add(index);
        }

        sb.append("<");
        for(int i = 0; i < rtn.size() - 1; i++) {
            sb.append(rtn.get(i) + ", ");
        }
        sb.append(rtn.get(rtn.size() - 1) + ">");

        System.out.println(sb);
    }
}