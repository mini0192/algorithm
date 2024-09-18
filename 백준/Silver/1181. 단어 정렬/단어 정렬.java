import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String data = br.readLine();
            boolean isGood = true;
            for(String s : list) {
                if(s.equals(data)) {
                    isGood = false;
                    break;
                }
            }
            if(isGood) list.add(data);
        }

       Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) return o1.length() - o2.length();
                return o1.compareTo(o2);
            }
        });

        for(String s : list) {
            sb.append(s);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}