import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] datas = new int[N];
        String[] inData = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            datas[i] = Integer.parseInt(inData[i]);
        }
        Arrays.sort(datas);

        int count = 0;
        for(int i = 0; i < N; i++) {
            int target = datas[i];

            int min = 0;
            int max = N - 1;

            while(min < max) {
                if(min == i) {
                    min++;
                    continue;
                }

                if(max == i) {
                    max--;
                    continue;
                }

                int sum = datas[min] + datas[max];
                if(sum == target) {
                    count++;
                    break;
                }
                if(sum > target) max--;
                else min++;
            }
        }
        System.out.println(count);
    }
}

