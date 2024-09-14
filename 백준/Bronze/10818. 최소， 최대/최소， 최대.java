import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] S = br.readLine().split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(String s : S) {
            int data = Integer.parseInt(s);
            max = Math.max(max, data);
            min = Math.min(min, data);
        }

        System.out.println(min + " " + max);
    }
}