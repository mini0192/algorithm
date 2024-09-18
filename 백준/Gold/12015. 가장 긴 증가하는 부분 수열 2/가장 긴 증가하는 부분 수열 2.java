import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];

        String[] data = br.readLine().split(" ");
        for(int i = 0; i < data.length; i++) {
            A[i] = Integer.parseInt(data[i]);
        }

        List<Integer> rtn = new ArrayList<>();
        rtn.add(A[0]);

        for(int i = 1; i < data.length; i++) {
            int start = 0;
            int end = rtn.size();

            while(start < end) {
                int mid = (start + end) / 2;

                if(A[i] > rtn.get(mid)) start = mid + 1;
                else end = mid;
            }
            if(end > rtn.size() - 1) rtn.add(A[i]);
            else rtn.set(end, A[i]);
        }

        System.out.println(rtn.size());
    }
}