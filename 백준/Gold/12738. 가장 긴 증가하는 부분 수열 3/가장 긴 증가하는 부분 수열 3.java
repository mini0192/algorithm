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

        int[] arr = new int[N];
        arr[0] = datas[0];

        int len = 1;
        for(int i = 1; i < N; i++) {
            int data = datas[i];

            int low = 0;
            int high = len;

            while(low < high) {
                int mid = (low + high) / 2;
                if(arr[mid] < data) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if(low == len) len++;
            arr[low] = data;
        }
        System.out.println(len);
    }
}

