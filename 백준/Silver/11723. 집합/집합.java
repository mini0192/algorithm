import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        Set<Integer> data = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            if(str[0].equals("add")) data.add(Integer.parseInt(str[1]));

            else if(str[0].equals("remove")) data.remove(Integer.parseInt(str[1]));

            else if(str[0].equals("check")) {
                if(data.contains(Integer.parseInt(str[1]))) sb.append("1\n");
                else sb.append("0\n");
            }

            else if(str[0].equals("toggle")) {
                if(data.contains(Integer.parseInt(str[1]))) data.remove(Integer.parseInt(str[1]));
                else data.add(Integer.parseInt(str[1]));
            }

            else if(str[0].equals("all")) {
                data = new HashSet<>();
                for(int j = 1; j <= 20; j++) {
                    data.add(j);
                }
            }

            else if(str[0].equals("empty")) data.clear();
        }

        System.out.println(sb);
    }
}