import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dpA = new int[N];
        int[] dpB = new int[N];

        for(int i = 0; i < N; i++) {
            dpA[i] = dpB[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) dpA[i] = Math.max(dpA[i], dpA[j] + 1);
            }
        }

        for(int i = N - 1; i >= 0; i--) {
            for(int j = N - 1; j >= i; j--) {
                if(A[i] > A[j]) dpB[i] = Math.max(dpB[i], dpB[j] + 1);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dpA[i] + dpB[i] - 1);
        }

        System.out.println(max);
    }
}
