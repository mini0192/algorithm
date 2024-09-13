import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());

        Map<Character, int[]> cache = new HashMap<>();

        int[] rtn = new int[N];

        for(int loop = 0; loop < N; loop++) {
            String[] get = br.readLine().split(" ");
            char check = get[0].charAt(0);
            int l = Integer.parseInt(get[1]);
            int r = Integer.parseInt(get[2]);

            int[] data;
            if(cache.containsKey(check)) data = cache.get(check);
            else {
                data = new int[line.length];
                data[0] = line[0] == check ? 1 : 0;
                for (int c = 1; c < line.length; c++) {
                    int add = line[c] == check ? 1 : 0;
                    data[c] = data[c - 1] + add;
                }
                cache.put(check, data);
            }

            if(l == 0) rtn[loop] = data[r];
            else rtn[loop] = data[r] - data[l - 1];
        }

        for(int i : rtn) {
            System.out.println(i);
        }
    }
}