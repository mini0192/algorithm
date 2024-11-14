import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = Integer.parseInt(br.readLine());

        if(data % 4 == 0 && data % 100 != 0) System.out.println(1);
        else if(data % 400 == 0) System.out.println(1);
        else System.out.println(0);
    }
}
