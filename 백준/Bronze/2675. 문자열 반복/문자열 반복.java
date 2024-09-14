import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < N; i++) {
            int count = scan.nextInt();
            String[] data = scan.next().split("");

            for(String d : data) {
                for (int j = 0; j < count; j++) {
                    sb.append(d);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}