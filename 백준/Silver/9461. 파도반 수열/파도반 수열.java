import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for(int count = 0; count < N; count++) {
            int data = Integer.parseInt(br.readLine());

            if(data < 4) {
                sb.append("1\n");
                continue;
            }

            long[] f = new long[data + 1];

            f[1] = 1;
            f[2] = 1;
            f[3] = 1;

            for(int i = 4; i <= data; i++) {
                f[i] = f[i - 2] + f[i - 3];
            }
            sb.append(f[data] + "\n");
        }

        System.out.println(sb);
    }
}