import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] datas = new int[N];
        for(int i = 0; i < N; i++) {
            datas[i] = scan.nextInt();
        }
        Arrays.sort(datas);
        for(int d : datas) {
            System.out.println(d);
        }
    }
}
